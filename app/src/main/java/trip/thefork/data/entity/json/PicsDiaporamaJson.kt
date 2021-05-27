package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PicsDiaporamaJson(
    @SerialName("label")
    val label: String,
    @SerialName("240x135")
    val x135: String,
    @SerialName("480x270")
    val x270: String,
    @SerialName("612x344")
    val x344: String,
    @SerialName("664x374")
    val x374: String,
    @SerialName("1350x759")
    val x759: String
)