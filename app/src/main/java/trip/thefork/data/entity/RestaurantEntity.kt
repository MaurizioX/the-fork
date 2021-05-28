package trip.thefork.data.entity

import trip.thefork.data.entity.json.MenusJson

data class RestaurantEntity(
    val name: String,
    val location: GpsLoc,
    val avg: String,
    val diaporamaList: List<String>,
    val menus: MenusJson,
    val description: String,
    val hourOpen: String,
    val cardsStart: List<Card>,
    val cardsMain: List<Card>,
    val cardsDessert: List<Card>
)

class GpsLoc(val lat:Double,val lon:Double)
data class Card(val description: String, val price: Double)
