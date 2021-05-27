package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MichelinDetailJson(
    @SerialName("is_michelin")
    val isMichelin: Boolean
)