package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HighlightedTagJson(
    @SerialName("id")
    val id: Int,
    @SerialName("indexable")
    val indexable: Boolean,
    @SerialName("slug")
    val slug: String,
    @SerialName("text")
    val text: String,
    @SerialName("type")
    val type: String
)