package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenusJson(
    @SerialName("menus_diner_week")
    val menusDinerWeek: MenusDinerWeekJson,
    @SerialName("menus_diner_weekend")
    val menusDinerWeekend: MenusDinerWeekendJson,
    @SerialName("menus_lunch_week")
    val menusLunchWeek: MenusLunchWeekJson,
    @SerialName("menus_lunch_weekend")
    val menusLunchWeekend: MenusLunchWeekendJson
)