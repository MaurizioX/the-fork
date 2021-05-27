package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestaurantTagsItemJson(
    @SerialName("category_name")
    val categoryName: String,
    @SerialName("category_pic")
    val categoryPic: String,
    @SerialName("id_restaurant_tag_category")
    val idRestaurantTagCategory: Int,
)