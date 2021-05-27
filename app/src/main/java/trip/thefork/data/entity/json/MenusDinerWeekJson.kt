package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenusDinerWeekJson(
    @SerialName("max_price")
    val maxPrice: Int,
    @SerialName("min_price")
    val minPrice: Int,
    @SerialName("week_time")
    val weekTime: String
)