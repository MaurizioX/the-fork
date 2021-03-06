package trip.thefork.data.services

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import io.ktor.client.features.*
import trip.thefork.data.entity.Card
import trip.thefork.data.entity.GpsLoc
import trip.thefork.data.entity.RestaurantEntity
import trip.thefork.data.entity.json.RestaurantInfoJson
import trip.thefork.data.services.api.RestaurantApi
import trip.thefork.data.services.infra.NetworkHandler

interface RestaurantService {
    suspend fun getRestaurantInfo(restaurantId: String): Either<Failure, RestaurantEntity>
}


class InfraRestaurantService(
    private val networkHandler: NetworkHandler,
    private val restaurantApi: RestaurantApi,
    private val jsonMapper: (RestaurantInfoJson) -> RestaurantEntity = mapper,
    private val errorMap: (Exception) -> Failure = errorMapper
) : RestaurantService {
    override suspend fun getRestaurantInfo(restaurantId: String): Either<Failure, RestaurantEntity> =
        if (networkHandler.isNetworkAvailable())
            try {
                jsonMapper(restaurantApi.getRestaurantKtor(restaurantId)).right()
            } catch (e: Exception) {
                errorMap(e).left()
            }
        else Failure.NetworkConnection.left()
}

private val mapper: (RestaurantInfoJson) -> RestaurantEntity = { restaurantInfo ->
    restaurantInfo.data.let { dataJson ->
        RestaurantEntity(
            name = dataJson.name,
            location = GpsLoc(dataJson.gpsLat, dataJson.gpsLong),
            dataJson.avgRateEvolution,
            diaporamaList = dataJson.picsDiaporama.map { it.x135 },
            menus = dataJson.menus,
            description = dataJson.description,
            hourOpen = dataJson.hourOpen,
            cardsStart = listOf<Card>(
                Card(dataJson.cardStart1, dataJson.priceCardStart1),
                Card(dataJson.cardStart2, dataJson.priceCardStart2),
                Card(dataJson.cardStart3, dataJson.priceCardStart3)
            ),
            cardsMain = listOf<Card>(
                Card(dataJson.cardMain1, dataJson.priceCardMain1),
                Card(dataJson.cardMain2, dataJson.priceCardMain2),
                Card(dataJson.cardMain3, dataJson.priceCardMain3)
            ),
            cardsDessert = listOf<Card>(
                Card(dataJson.cardDessert1, dataJson.priceCardDessert1.toDouble()),
                Card(dataJson.cardDessert2 ,dataJson.priceCardDessert2),
                Card(dataJson.cardDessert3, dataJson.priceCardDessert3)
            )

        )
    }
}

private val errorMapper: (Exception) -> Failure = {
    when (it) {
        is ServerResponseException -> Failure.HttpErrorInternalServerError(it)
        is ClientRequestException ->
            when (it.response.status.value) {
                400 -> Failure.HttpErrorBadRequest(it)
                401 -> Failure.HttpErrorUnauthorized(it)
                403 -> Failure.HttpErrorForbidden(it)
                404 -> Failure.HttpErrorNotFound(it)
                else -> Failure.HttpError(it)
            }
        is RedirectResponseException -> Failure.RedirectError(it)
        else -> Failure.GenericError(it)
    }
}