package trip.thefork.domain.usecase

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import trip.thefork.data.entity.RestaurantEntity
import trip.thefork.data.services.Failure
import trip.thefork.data.services.RestaurantService
import trip.thefork.domain.elements.RestaurantElement

@RunWith(BlockJUnit4ClassRunner::class)
class GetRestaurantUseCaseTest {
    companion object {
        private val RESTAURANT_ELEMENT_MOCK: RestaurantElement = mockk()
        private val RESTAURANT_ENTITY_MOCK: RestaurantEntity = mockk()
        private const val RESTAURANT_ID = "restaurant_id"
        private val ERROR_RESPONSE :Failure = mockk()
    }

    private lateinit var serverResponse: Either<Failure, RestaurantEntity>
    private lateinit var result: Either<Failure, RestaurantElement>
    private lateinit var restaurantId: String
    private lateinit var entityMapper: (RestaurantEntity) -> RestaurantElement
    private lateinit var restaurantService: RestaurantService
    private lateinit var useCase: GetRestaurantUseCase

    @Test
    fun `check a successful mapped return`() = runBlocking {
        `given mocked restaurantService`()
        `given a restaurant id`()
        `given success response from server`()
        `given service response for a given restaurant id`()
        `given an entity mapper `()

        `given a just created use case`()
        `when action is executed with a restaurant id`()


        `them a successful response is returned`()
    }

    private fun `them a successful response is returned`() {
        Assert.assertEquals(
            "Right successful response is needed",
            result,
            RESTAURANT_ELEMENT_MOCK.right()
        )
    }

    private fun `given a restaurant id`() {
        restaurantId = RESTAURANT_ID
    }

    private fun `given success response from server`() {
        serverResponse = RESTAURANT_ENTITY_MOCK.right()
    }

    private fun `given an entity mapper `() {
        entityMapper = mockk()
        every { entityMapper.invoke(RESTAURANT_ENTITY_MOCK) }.returns(RESTAURANT_ELEMENT_MOCK)
    }

    @Test
    fun `check a error mapped return`() = runBlocking {
        `given mocked restaurantService`()
        `given a restaurant id`()
        `given error response from server`()
        `given service response for a given restaurant id`()
        `given an entity mapper `()
        `given a just created use case`()

        `when action is executed with a restaurant id`()

        `them an error is returned`()
    }

    private fun `them an error is returned`() {
        Assert.assertEquals("Left error response is needed", result, ERROR_RESPONSE.left())
    }

    private fun `given mocked restaurantService`() {
        restaurantService = mockk()
    }

    private fun `given error response from server`() {
        serverResponse = ERROR_RESPONSE.left()
    }

    private fun `given service response for a given restaurant id`() {
        coEvery { restaurantService.getRestaurantInfo(RESTAURANT_ID) }.returns(
            serverResponse
        )
    }

    private fun `given a just created use case`() {
        useCase = GetRestaurantUseCase(restaurantService, entityMapper)
    }

    private suspend fun `when action is executed with a restaurant id`() {
        result = useCase.action(restaurantId)
    }

}