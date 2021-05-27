package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatingsJson(
    @SerialName("ambience_rate")
    val ambienceRate: String?,
    @SerialName("food_rate")
    val foodRate: String?,
    @SerialName("global_rate")
    val globalRate: String?,
    @SerialName("noice_rate")
    val noiceRate: String?,
    @SerialName("price_rate")
    val priceRate: String?,
    @SerialName("service_rate")
    val serviceRate: String?,
    @SerialName("waiting_rate")
    val waitingRate: String?
)