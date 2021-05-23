package trip.thefork.ui.features.restaurant

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

@RunWith(BlockJUnit4ClassRunner::class)
class RestaurantViewModelTest {
    private lateinit var viewModel: RestaurantViewModel

    @Test
    fun `check just create, them state is loading state`() {
        `given just create view model `()

        `them state is loading`()
    }

    private fun `them state is loading`() {
        Assert.assertEquals(viewModel.state.value, RestaurantViewModel.RestaurantState.Loading)
    }

    private fun `given just create view model `() {
        viewModel = RestaurantViewModel()
    }
}