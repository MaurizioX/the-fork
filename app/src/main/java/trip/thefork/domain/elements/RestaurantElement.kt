package trip.thefork.domain.elements

import trip.thefork.data.entity.Card
import trip.thefork.data.entity.json.MenusJson

data class RestaurantElement(
    val name: String,
    val diaporamaList: List<String>,
    val menus: MenusJson,
    val description: String,
    val hourOpen: String,
    val cardsStart: List<Card>,
    val cardsMain: List<Card>,
    val cardsDessert: List<Card>
)
