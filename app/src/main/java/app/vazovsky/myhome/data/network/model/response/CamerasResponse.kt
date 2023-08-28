package app.vazovsky.myhome.data.network.model.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
class CamerasResponse(
    @SerialName("success") val success: Boolean?,
    @SerialName("data") val data: CamerasListData?,
) : Parcelable {

    @Serializable
    @Parcelize
    class CamerasListData(
        @SerialName("room") val room: List<String>?,
        @SerialName("cameras") val cameras: List<CameraData>?,
    ) : Parcelable {

        @Serializable
        @Parcelize
        class CameraData(
            @SerialName("name") val name: String?,
            @SerialName("snapshot") val snapshotUrl: String?,
            @SerialName("room") val room: String?,
            @SerialName("id") val id: Int?,
            @SerialName("favorites") val favorites: Boolean?,
            @SerialName("rec") val isRecording: Boolean?,
        ) : Parcelable
    }
}