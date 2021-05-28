package trip.thefork.ui.features.restaurant

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import trip.thefork.domain.elements.RestaurantElement
import trip.thefork.domain.usecase.GetRestaurantUseCase
import trip.thefork.ui.MVIViewModel
import trip.thefork.ui.data.DescriptionUI
import trip.thefork.ui.data.RestaurantElementUi
import trip.thefork.ui.data.RestaurantUI
import trip.thefork.ui.data.TitleUi
import javax.inject.Inject

typealias MVIRestaurant = MVIViewModel<RestaurantViewModel.RestaurantAction,
        RestaurantViewModel.RestaurantState>

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val getRestaurantUseCase: GetRestaurantUseCase,
    //TODO this parameter should be injected when user previously select Restaurant
    private val restaurantId: String = "14163"
) :
    MVIViewModel<RestaurantViewModel.RestaurantAction, RestaurantViewModel.RestaurantState>() {
    private val _state = MutableStateFlow<RestaurantState>(RestaurantState.Loading)
    override val state = _state

    init {
        viewModelScope.launch {
            _state.value =
                getRestaurantUseCase.action(restaurantId)
                    .fold({ RestaurantState.Failed }) { element ->
                        var count = 60

                        val sequence = generateSequence {
                            (count--).takeIf { it > 0 } // will return null, when value becomes non-positive,
                            // and that will terminate the sequence
                        }

                        val items = mutableListOf<RestaurantElementUi>().apply {

                            add(TitleUi("Start"))
                            addAll(element.cardsStart.map {
                                DescriptionUI(
                                    it.description,
                                    it.price.toString()
                                )
                            })
                            add(TitleUi("Main"))
                            addAll(element.cardsMain.map {
                                DescriptionUI(
                                    it.description,
                                    it.price.toString()
                                )
                            })
                            add(TitleUi("Desert"))
                            addAll(element.cardsDessert.map {
                                DescriptionUI(
                                    it.description,
                                    it.price.toString()
                                )
                            })
                        }


                        RestaurantState.Loaded(
                            element.toRestaurantUI(),
                            restaurantElementUi = items
                        )
                    }
        }
    }

    sealed interface RestaurantAction : Action {}
    sealed interface RestaurantState : State {
        object Loading : RestaurantState
        data class Loaded(
            val restaurant: RestaurantUI,
            val restaurantElementUi: List<RestaurantElementUi>
        ) : RestaurantState

        object Failed : RestaurantState
    }

    override fun processAction(action: RestaurantAction) {
        TODO("Not yet implemented")
    }
}

private fun RestaurantElement.toRestaurantUI(): RestaurantUI =
    RestaurantUI(name = name, diaporamaList = diaporamaList)
