package trip.thefork.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow


abstract class MVIViewModel<A : MVIViewModel.Action, S : MVIViewModel.State> : ViewModel() {

    abstract val state: StateFlow<S>
    abstract fun processAction(action: A)
    interface Action
    interface State
}