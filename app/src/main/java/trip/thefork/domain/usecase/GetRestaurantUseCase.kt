package trip.thefork.domain.usecase

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import trip.thefork.data.entity.RestaurantEntity
import trip.thefork.data.services.RestaurantService
import trip.thefork.domain.elements.RestaurantElement

class GetRestaurantUseCase constructor(
    private val restaurantService: RestaurantService,
    private val entityMapper: (RestaurantEntity) -> RestaurantElement
) {
    suspend fun action(restaurantId: String): Either<String, RestaurantElement> =
        restaurantService.getRestaurantInfo(restaurantId)
            .fold({ it.left() }, { entityMapper(it).right() })

}
