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
//                    configureCarusel(state)
                    name.text = state.restaurant.name
                }
            }
        }
    }.root

    private fun  RestaurantFragmentBinding.configureCarusel(
        state: RestaurantViewModel.RestaurantState.Loaded
    ) {
        state.restaurant.diaporamaList.let { imageList ->
//            carousel.setAdapter(object : Carousel.Adapter {
//                override fun count(): Int {
//                    return imageList.size
//                }
//
//                override fun populate(view: View, index: Int) {
//                    if (view is ImageView) {
//                        Picasso.with(context).load(imageList[index]).into(view)
//                    }
//                }
//
//                override fun onNewItem(index: Int) {
//                }
//            })
        }
    }

}