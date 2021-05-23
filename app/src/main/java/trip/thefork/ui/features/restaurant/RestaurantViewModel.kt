package trip.thefork.ui.features.restaurant

import kotlinx.coroutines.flow.MutableStateFlow
import trip.thefork.ui.MVIViewModel

class RestaurantViewModel :
    MVIViewModel<RestaurantViewModel.RestaurantAction, RestaurantViewModel.RestaurantState>() {
    private val _state = MutableStateFlow<RestaurantState>(RestaurantState.Loading)
    override val state = _state

    sealed interface RestaurantAction : Action {}
    sealed interface RestaurantState : State {
        object Loading : RestaurantState
    }

    override fun processAction(action: RestaurantAction) {
        TODO("Not yet implemented")
    }
}