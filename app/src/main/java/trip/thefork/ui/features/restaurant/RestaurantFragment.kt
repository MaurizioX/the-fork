package trip.thefork.ui.features.restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import trip.thefork.databinding.RestaurantFragmentBinding


@AndroidEntryPoint
class RestaurantFragment : Fragment() {

    companion object {
        fun newInstance() = RestaurantFragment()
    }

    private val viewModel: MVIRestaurant by viewModels<RestaurantViewModel>()
    private val restaurantAdapter = RestaurantAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = RestaurantFragmentBinding.inflate(inflater, container, false).apply {
        recyclerList.layoutManager = LinearLayoutManager(context)
        recyclerList.adapter = restaurantAdapter
        imagePager.orientation = androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                if (state is RestaurantViewModel.RestaurantState.Loaded) {
                    restaurantAdapter.submitList(state.restaurantElementUi)
                    imagePager.adapter = ImageAdapter(state.restaurant.diaporamaList)
                    name.text = state.restaurant.name
                }
            }
        }
    }.root
}

