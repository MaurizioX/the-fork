package trip.thefork.ui.features.restaurant

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import arrow.core.left
import arrow.core.right
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import trip.thefork.data.services.Failure
import trip.thefork.domain.elements.RestaurantElement
import trip.thefork.domain.usecase.GetRestaurantUseCase
import trip.thefork.ui.data.RestaurantUI

@RunWith(BlockJUnit4ClassRunner::class)
class RestaurantViewModelTest {
    companion object {
        private const val NAME01: String = "Name 1"
        private val FAILURE:Failure = mockk()
        private val DIAPORAMA_LIST = mockk<List<String>>()
    }

    private lateinit var someName: String
    private lateinit var restaurantElement: RestaurantElement
    private lateinit var getRestaurantUseCase: GetRestaurantUseCase
    private lateinit var viewModel: RestaurantViewModel
    private lateinit var restaurantUI: RestaurantUI
    private lateinit var restaurantId: String

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `check just create view model, when data is loaded successful`() {
        `given a mocked use case`()
        `given a restaurant id`()
        `given a successful response for a given restaurant id`()
        `given just create view model `()

        `them state is loading`()
    }


    @Test
    fun `check just create view model, when there is an error loading data`() {
        `given a mocked use case`()
        `given a restaurant id`()
        `given an error response for a given restaurant id`()
        `given just create view model `()

        `them state is Failed`()
    }

    private fun `given an error response for a given restaurant id`() {
        coEvery { getRestaurantUseCase.action(restaurantId) }.returns(FAILURE.left())
    }


    private fun `given a successful response for a given restaurant id`() {
        restaurantElement = mockk()
        someName = NAME01
        every { restaurantElement.name }.returns(someName)
        every { restaurantElement.diaporamaList }.returns(DIAPORAMA_LIST)
        coEvery { getRestaurantUseCase.action(restaurantId) }.returns(restaurantElement.right())
    }

    private fun `given a restaurant id`() {
        restaurantId = "restaurant_id"
    }

    private fun `given a mocked use case`() {
        getRestaurantUseCase = mockk()
    }

    private fun `them state is Failed`() {
        Assert.assertEquals(
            viewModel.state.value,
            RestaurantViewModel.RestaurantState.Failed
        )
    }

    private fun `them state is loading`() {
        Assert.assertEquals(
            "",
            viewModel.state.value,
            RestaurantViewModel.RestaurantState.Loaded(RestaurantUI(NAME01, DIAPORAMA_LIST))
        )
    }

    private fun `given just create view model `() {
        viewModel = RestaurantViewModel(getRestaurantUseCase, restaurantId)
    }
}