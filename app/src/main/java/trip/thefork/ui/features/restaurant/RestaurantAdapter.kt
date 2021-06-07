package trip.thefork.ui.features.restaurant

import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import trip.thefork.ui.data.RestaurantElementUi
import trip.thefork.ui.features.restaurant.delegate.ButtonDelegate
import trip.thefork.ui.features.restaurant.delegate.DescriptionDelegate
import trip.thefork.ui.features.restaurant.delegate.RestaurantVHDelegate
import trip.thefork.ui.features.restaurant.delegate.TitleDelegate


class RestaurantAdapter : ListAdapter<RestaurantElementUi, RestaurantElementUiVH>(RestaurantDiff) {
    private val delegates =
        SparseArray<RestaurantVHDelegate<RestaurantElementUi, RestaurantElementUiVH>>().apply {
            appendDelegate(TitleDelegate as RestaurantVHDelegate<RestaurantElementUi, RestaurantElementUiVH>)
            appendDelegate(DescriptionDelegate as RestaurantVHDelegate<RestaurantElementUi, RestaurantElementUiVH>)
            appendDelegate(ButtonDelegate  as RestaurantVHDelegate<RestaurantElementUi, RestaurantElementUiVH> )
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantElementUiVH =
        delegates.get(viewType).createViewHolder(parent)

    override fun onBindViewHolder(holder: RestaurantElementUiVH, position: Int) {
        getItem(position)?.let { item ->
            delegates.get(item.type).bindViewHolder(
                holder,
                item
            )
        }
    }

    override fun getItemViewType(position: Int): Int  = getItem(position).type

}

private fun SparseArray<RestaurantVHDelegate<RestaurantElementUi, RestaurantElementUiVH>>.appendDelegate(
    delegate: RestaurantVHDelegate<RestaurantElementUi, RestaurantElementUiVH>
) {
    append(delegate.viewType, delegate)
}


abstract class RestaurantElementUiVH(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: RestaurantElementUi)

}

object RestaurantDiff : DiffUtil.ItemCallback<RestaurantElementUi>() {
    override fun areItemsTheSame(
        oldItem: RestaurantElementUi,
        newItem: RestaurantElementUi
    ): Boolean = false


    override fun areContentsTheSame(
        oldItem: RestaurantElementUi,
        newItem: RestaurantElementUi
    ): Boolean = false
}
