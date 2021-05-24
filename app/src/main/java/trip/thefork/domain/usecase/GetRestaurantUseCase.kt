package trip.thefork.domain.usecase

import arrow.core.Either
import trip.thefork.domain.elements.RestaurantElement

class GetRestaurantUseCase {
    suspend fun action(restaurantId: String): Either<String, RestaurantElement> {
        TODO("Not yet implemented")
    }

}
