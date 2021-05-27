package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestaurantInfoJson(
    @SerialName("data")
    val data: DataJson,
//    @SerialName("result")
//    val result: Int,
//    @SerialName("result_detail")
//    val resultDetail: String,
//    @SerialName("result_msg")
//    val resultMsg: String
)