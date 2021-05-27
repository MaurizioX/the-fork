package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PicsMainJson(
    @SerialName("160x120")
    val x120: String,
    @SerialName("240x135")
    val x135: String,
    @SerialName("184x184")
    val x184: String,
    @SerialName("480x270")
    val x270: String,
    @SerialName("612x344")
    val x344: String,
    @SerialName("664x374")
    val x374: String,
    @SerialName("80x60")
    val x60: String,
    @SerialName("1350x759")
    val x759: String,
    @SerialName("92x92")
    val x92: String
)