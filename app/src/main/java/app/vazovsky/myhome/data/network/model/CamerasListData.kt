package app.vazovsky.myhome.data.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName

@Parcelize
class CamerasListData(
    @SerialName("room") val room: List<String>?,
    @SerialName("cameras") val cameras: List<CameraData>?,
) : Parcelable