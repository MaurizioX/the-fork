package trip.thefork.ui.features.restaurant.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import trip.thefork.databinding.TitleUiItemBinding
import trip.thefork.ui.data.RestaurantElementUi
import trip.thefork.ui.data.TitleUi
import trip.thefork.ui.features.restaurant.RestaurantElementUiVH

private val ViewGroup.inflater: LayoutInflater
    get() = LayoutInflater.from(context)

object TitleDelegate : RestaurantVHDelegate<TitleUi, TitleUiVH> {
    override fun createViewHolder(parent: ViewGroup): TitleUiVH =
        TitleUiVH(TitleUiItemBinding.inflate(parent.inflater, parent, false))

    override val viewType: Int
        get() = TitleUi.TYPE
}

class TitleUiVH(private val binding: TitleUiItemBinding) : RestaurantElementUiVH(binding.root) {
    override fun bind(item: RestaurantElementUi) {
         if (item is TitleUi) {
             binding.title = item
             binding.executePendingBindings()
         }

    }

}
//private inline fun  <reified T> checkType(item: RestaurantElementUi):T? = if (item == T::class)
//    item as T
//else
//    null


