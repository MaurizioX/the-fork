package trip.thefork.data.services.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

import trip.thefork.data.entity.RestaurantEntity
import trip.thefork.data.entity.json.RestaurantInfoJson

class RestaurantApi constructor(private val client: HttpClient) {
    suspend fun getRestaurantKtor(
        restaurantId: String
    ): RestaurantInfoJson = client.get(URLBuilder().apply {
        protocol = URLProtocol.HTTP
        host = "api.lafourchette.com"
        encodedPath = "api"
        parameters.apply {
            append("key","IPHONEPRODEDCRFV")
            append("method", "restaurant_get_info")
            append("id_restaurant", restaurantId)
        }

    }.build())
}