package trip.thefork.ui.features.restaurant.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import trip.thefork.databinding.ButtonUiItemBinding
import trip.thefork.databinding.DescriptionUiItemBinding
import trip.thefork.databinding.TitleUiItemBinding
import trip.thefork.ui.data.ButtonUI
import trip.thefork.ui.data.DescriptionUI
import trip.thefork.ui.data.RestaurantElementUi
import trip.thefork.ui.data.TitleUi
import trip.thefork.ui.features.restaurant.RestaurantElementUiVH
import trip.thefork.ui.features.restaurant.RestaurantViewModel

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

object DescriptionDelegate : RestaurantVHDelegate<DescriptionUI, DescriptionUIVH> {
    override fun createViewHolder(parent: ViewGroup): DescriptionUIVH = DescriptionUIVH(
        DescriptionUiItemBinding.inflate(parent.inflater, parent, false)
    )

    override val viewType: Int
        get() = DescriptionUI.TYPE
}

class DescriptionUIVH(private val binding: DescriptionUiItemBinding) :
    RestaurantElementUiVH(binding.root) {
    override fun bind(item: RestaurantElementUi) {
        if (item is DescriptionUI) {
            binding.description = item
            binding.executePendingBindings()
        }
    }
}

object ButtonDelegate : RestaurantVHDelegate<ButtonUI<
        RestaurantViewModel.RestaurantAction,RestaurantViewModel.RestaurantState>, ButtonUIVH> {
    override fun createViewHolder(parent: ViewGroup) = ButtonUIVH(
        ButtonUiItemBinding.inflate(parent.inflater, parent, false)
    )

    override val viewType: Int
        get() = ButtonUI.TYPE
}

class ButtonUIVH(private val binding: ButtonUiItemBinding) : RestaurantElementUiVH(binding.root) {
    override fun bind(item: RestaurantElementUi) {
        if (item is ButtonUI<*,*>) {
            binding.action = RestaurantViewModel.RestaurantAction.CreateReserve
            binding.viewModel = item.viewModel

            binding.executePendingBindings()
        }
    }
}
