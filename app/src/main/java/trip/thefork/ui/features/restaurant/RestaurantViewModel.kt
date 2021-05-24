package trip.thefork.ui.features.restaurant

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import trip.thefork.domain.elements.RestaurantElement
import trip.thefork.domain.usecase.GetRestaurantUseCase
import trip.thefork.ui.MVIViewModel
import trip.thefork.ui.data.RestaurantUI
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor (
    private val getRestaurantUseCase: GetRestaurantUseCase,
    //TODO this parameter should be injected when user previously select Restaurant
    private val restaurantId: String = "40370"
) :
    MVIViewModel<RestaurantViewModel.RestaurantAction, RestaurantViewModel.RestaurantState>() {
    private val _state = MutableStateFlow<RestaurantState>(RestaurantState.Loading)
    override val state = _state

    init {
        viewModelScope.launch {
            _state.value =
                getRestaurantUseCase.action(restaurantId)
                    .fold({ RestaurantState.Failed }) { RestaurantState.Loaded(it.toRestaurantUI()) }
        }
    }

    sealed interface RestaurantAction : Action {}
    sealed interface RestaurantState : State {
        object Loading : RestaurantState
        data class Loaded(val restaurant: RestaurantUI) : RestaurantState
        object Failed : RestaurantState
    }

    override fun processAction(action: RestaurantAction) {
        TODO("Not yet implemented")
    }
}

private fun RestaurantElement.toRestaurantUI(): RestaurantUI = RestaurantUI(name = name)
