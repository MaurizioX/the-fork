package trip.thefork.ui.features.restaurant

import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import trip.thefork.ui.data.RestaurantElementUi
import trip.thefork.ui.features.restaurant.delegate.RestaurantVHDelegate


class RestaurantAdapter : ListAdapter<RestaurantElementUi, RestaurantElementUiVH>(RestaurantDiff) {
    private val delegates =
        SparseArray<RestaurantVHDelegate<RestaurantElementUi, RestaurantElementUiVH>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantElementUiVH =
        delegates.get(viewType).createViewHolder(parent)

    override fun onBindViewHolder(holder: RestaurantElementUiVH, position: Int) {
        getItem(position)?.let { item ->
            delegates.get(item.type).bindViewHolder(holder, item)
        }
    }

}

abstract class RestaurantElementUiVH(view: View) : RecyclerView.ViewHolder(view) {

}

object RestaurantDiff : DiffUtil.ItemCallback<RestaurantElementUi>() {
    override fun areItemsTheSame(
        oldItem: RestaurantElementUi,
        newItem: RestaurantElementUi
    ): Boolean  = false

    override fun areContentsTheSame(
        oldItem: RestaurantElementUi,
        newItem: RestaurantElementUi
    ): Boolean = false
}
