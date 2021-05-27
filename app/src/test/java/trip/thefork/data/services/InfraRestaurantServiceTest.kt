package trip.thefork.data.services

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import io.ktor.client.features.*
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import trip.thefork.data.entity.RestaurantEntity
import trip.thefork.data.entity.json.RestaurantInfoJson
import trip.thefork.data.services.api.RestaurantApi
import trip.thefork.data.services.infra.NetworkHandler

@RunWith(BlockJUnit4ClassRunner::class)
class InfraRestaurantServiceTest {
    companion object {
        private const val RESTAURANT_ID = "some id"
        private val RESPONSE: RestaurantEntity = mockk()
        private val RESTAURANT_JSON: RestaurantInfoJson = mockk()
        private val SERVER_ERROR = mockk<ServerResponseException>()
        private val FAILURE_ERROR = mockk<Failure>()
    }

    private lateinit var failureError: Failure
    private lateinit var exceptionThrow: Exception
    private lateinit var restaurantJsonMock: RestaurantInfoJson
    private lateinit var mapper: (RestaurantInfoJson) -> RestaurantEntity
    private var networkStatus: Boolean = false
    private lateinit var returnedValue: Either<Failure, RestaurantEntity>
    private lateinit var restaurantId: String
    private lateinit var restaurantApi: RestaurantApi
    private lateinit var networkHandler: NetworkHandler
    private lateinit var restaurantService: InfraRestaurantService
    private lateinit var errorMapper: (Exception) -> Failure

    @Test
    fun `check fail when network is not available`() {
        `given mocked constructor parameters`()
        `given not available network status`()
        `given just created Restaurant service`()
        `given a restaurant id`()

        `whem restaurant Info is retrieved`()

        `them there is Network connection error`()
    }

    @Test
    fun `check success returned value `() {
        `given mocked constructor parameters`()
        `given available network status`()
        `given just created Restaurant service`()
        `given a restaurant id`()
        `given restaurant json mocked`()
        `given restaurant parsed returned for a id`()
        `given restaurant response mapped for a restaurant json`()

        `whem restaurant Info is retrieved`()

        `them there is successful returned value`()
    }

    @Test
    fun `check error handled value `() {
        `given mocked constructor parameters`()
        `given available network status`()
        `given just created Restaurant service`()
        `given a restaurant id`()
        `given restaurant json mocked`()
        exceptionThrow = SERVER_ERROR
        `given restaurant error returned for a id`()
        failureError = FAILURE_ERROR
        every { errorMapper.invoke(SERVER_ERROR) }.returns(failureError)
        `given restaurant response mapped for a restaurant json`()


        `whem restaurant Info is retrieved`()

        `them there is a server error`()
    }

    private fun `them there is a server error`() {
        Assert.assertEquals("", FAILURE_ERROR.left(), returnedValue)
    }

    private fun `given restaurant error returned for a id`() {
        coEvery { restaurantApi.getRestaurantKtor(restaurantId) }.throws(exceptionThrow)
    }

    private fun `given restaurant response mapped for a restaurant json`() {
        every { mapper.invoke(RESTAURANT_JSON) }.returns(RESPONSE)
    }

    private fun `given restaurant json mocked`() {
        restaurantJsonMock = RESTAURANT_JSON
    }

    private fun `given restaurant parsed returned for a id`() {
        coEvery { restaurantApi.getRestaurantKtor(restaurantId) }.returns(restaurantJsonMock)
    }

    private fun `them there is successful returned value`() {
        Assert.assertEquals("", RESPONSE.right(), returnedValue)
    }

    private fun `given available network status`() {
        networkStatus = true
        every { networkHandler.isNetworkAvailable() }.returns(networkStatus)
    }


    private fun `them there is Network connection error`() {
        Assert.assertEquals("", Failure.NetworkConnection.left(), returnedValue)
    }

    private fun `whem restaurant Info is retrieved`() {
        runBlocking {
            returnedValue = restaurantService.getRestaurantInfo(restaurantId)
        }
    }

    private fun `given a restaurant id`() {
        restaurantId = RESTAURANT_ID
    }

    private fun `given just created Restaurant service`() {
        restaurantService = InfraRestaurantService(
            networkHandler = networkHandler,
            restaurantApi = restaurantApi,
            jsonMapper = mapper,
            errorMap = errorMapper
        )
    }

    private fun `given not available network status`() {
        networkStatus = false
        every { networkHandler.isNetworkAvailable() }.returns(networkStatus)
    }

    private fun `given mocked constructor parameters`() {
        restaurantApi = mockk()
        networkHandler = mockk()
        mapper = mockk()
        errorMapper = mockk()
    }
}