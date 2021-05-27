package trip.thefork.ui.features.restaurant.delegate

import android.view.ViewGroup
import trip.thefork.ui.data.RestaurantElementUi
import trip.thefork.ui.features.restaurant.RestaurantElementUiVH

interface RestaurantVHDelegate<I:RestaurantElementUi,VH: RestaurantElementUiVH> {
    fun createViewHolder(parent: ViewGroup): VH
    fun bindViewHolder(holder: VH, item: I)
}
