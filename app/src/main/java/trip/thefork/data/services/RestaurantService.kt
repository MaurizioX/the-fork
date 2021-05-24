package trip.thefork.data.services

import arrow.core.Either
import io.ktor.client.features.*
import trip.thefork.data.entity.RestaurantEntity
import trip.thefork.data.services.api.RestaurantApi
import trip.thefork.data.services.infra.NetworkHandler

interface RestaurantService {
    suspend fun getRestaurantInfo(restaurantId: String): Either<Failure, RestaurantEntity>
}


class InfraRestaurantService(
    private val networkHandler: NetworkHandler,
    private val restaurantApi: RestaurantApi
) : RestaurantService {
    override suspend fun getRestaurantInfo(restaurantId: String): Either<Failure, RestaurantEntity> =
        when (networkHandler.isNetworkAvailable()) {
            true -> {
                try {
                    Either.Right(restaurantApi.getRestaurantKtor(restaurantId).toDomain())
                } catch (e: Exception) {
                    Either.Left(e.toCustomExceptions())
                }
            }
            else -> Either.Left(Failure.NetworkConnection)
        }
}

private fun RestaurantEntity.toDomain(): RestaurantEntity {
    TODO("Not yet implemented")
}

fun Exception.toCustomExceptions() = when (this) {
    is ServerResponseException -> Failure.HttpErrorInternalServerError(this)
    is ClientRequestException ->
        when (this.response.status.value) {
            400 -> Failure.HttpErrorBadRequest(this)
            401 -> Failure.HttpErrorUnauthorized(this)
            403 -> Failure.HttpErrorForbidden(this)
            404 -> Failure.HttpErrorNotFound(this)
            else -> Failure.HttpError(this)
        }
    is RedirectResponseException -> Failure.RedirectError(this)
    else -> Failure.GenericError(this)
}