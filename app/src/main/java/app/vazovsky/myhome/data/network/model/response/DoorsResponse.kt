package app.vazovsky.myhome.data.network.model.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
class DoorsResponse(
    @SerialName("success") val success: Boolean?,
    @SerialName("data") val data: List<DoorData>?,
) : Parcelable {

    @Serializable
    @Parcelize
    class DoorData(
        @SerialName("name") val name: String?,
        @SerialName("room") val room: String?,
        @SerialName("id") val id: Int?,
        @SerialName("favorites") val favorites: Boolean?,
    ) : Parcelable
}