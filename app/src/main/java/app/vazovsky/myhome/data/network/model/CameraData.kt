package app.vazovsky.myhome.data.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName

@Parcelize
class CameraData(
    @SerialName("name") val name: String?,
    @SerialName("snapshot") val snapshotUrl: String?,
    @SerialName("room") val room: String?,
    @SerialName("id") val id: Int?,
    @SerialName("favorites") val favorites: Boolean?,
    @SerialName("rec") val icRecording: Boolean?,
) : Parcelable