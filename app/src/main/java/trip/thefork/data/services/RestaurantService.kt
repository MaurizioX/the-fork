package trip.thefork.data.services

import arrow.core.Either
import trip.thefork.data.entity.RestaurantEntity

interface RestaurantService {
    suspend fun getRestaurantInfo(restaurantId: String): Either<String, RestaurantEntity>
}
