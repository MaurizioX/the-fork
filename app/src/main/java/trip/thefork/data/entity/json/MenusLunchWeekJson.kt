package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenusLunchWeekJson(
    @SerialName("max_price")
    val maxPrice: Int,
    @SerialName("min_price")
    val minPrice: Double,
    @SerialName("week_time")
    val weekTime: String
)