package trip.thefork.ui.features.restaurant

import android.content.Context
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import trip.thefork.R
import trip.thefork.domain.elements.RestaurantElement
import trip.thefork.domain.usecase.GetRestaurantUseCase
import trip.thefork.ui.MVIViewModel
import trip.thefork.ui.data.*
import javax.inject.Inject

typealias MVIRestaurant = MVIViewModel<RestaurantViewModel.RestaurantAction,
        RestaurantViewModel.RestaurantState>

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val getRestaurantUseCase: GetRestaurantUseCase,
    private val restaurantId: String,
    @ApplicationContext context: Context
) :
    MVIViewModel<RestaurantViewModel.RestaurantAction, RestaurantViewModel.RestaurantState>() {
    private val _state = MutableStateFlow<RestaurantState>(RestaurantState.Loading)
    override val state = _state
    private val resources = context.resources

    init {
        viewModelScope.launch {
            _state.value =
                getRestaurantUseCase.action(restaurantId)
                    .fold({ RestaurantState.Failed }) { element ->
                        RestaurantState.Loaded(
                            element.toRestaurantUI(),
                            restaurantElementUi = createUiItems(element)
                        )
                    }
        }
    }

    private fun createUiItems(element: RestaurantElement) =
        mutableListOf<RestaurantElementUi>().apply {

            add(TitleUi(resources.getString(R.string.start)))
            addAll(element.cardsStart.map {
                DescriptionUI(
                    it.description,
                    it.price.toString()
                )
            })

            add(TitleUi(resources.getString(R.string.main)))
            addAll(element.cardsMain.map {
                DescriptionUI(
                    it.description,
                    it.price.toString()
                )
            })

            add(TitleUi(resources.getString(R.string.desert)))
            addAll(element.cardsDessert.map {
                DescriptionUI(
                    it.description,
                    it.price.toString()
                )
            })

            add(ButtonUI(RestaurantAction.CreateReserve))
        }


    sealed interface RestaurantAction : Action {
        object CreateReserve : RestaurantAction
    }

    sealed interface RestaurantState : State {
        object Loading : RestaurantState
        data class Loaded(
            val restaurant: RestaurantUI,
            val restaurantElementUi: List<RestaurantElementUi>
        ) : RestaurantState

        object Failed : RestaurantState
    }

    override fun processAction(action: RestaurantAction) {
        Timber.d("Element clicked")
    }
}

private fun RestaurantElement.toRestaurantUI(): RestaurantUI =
    RestaurantUI(name = name, diaporamaList = diaporamaList)
