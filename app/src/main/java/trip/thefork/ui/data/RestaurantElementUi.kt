package trip.thefork.ui.data

sealed interface RestaurantElementUi {
    val type: Int
}

data class TitleUi(val name: String) : RestaurantElementUi {
    companion object {
        const val TYPE = 1
    }

    override val type: Int
        get() = TYPE
}
