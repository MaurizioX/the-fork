package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class YumsDetailJson(
    @SerialName("is_super_yums")
    val isSuperYums: Boolean,
    @SerialName("yums_count")
    val yumsCount: Int
)