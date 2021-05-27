package trip.thefork.ui.features.restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber
import trip.thefork.R


@AndroidEntryPoint
class RestaurantFragment : Fragment() {

    companion object {
        fun newInstance() = RestaurantFragment()
    }

    private val viewModel: MVIRestaurant by viewModels<RestaurantViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                Timber.i("current state $state")

            }
        }
        return inflater.inflate(R.layout.main_fragment, container, false)
    }
}