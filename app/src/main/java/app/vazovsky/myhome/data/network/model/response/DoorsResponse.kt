package app.vazovsky.myhome.data.network.model.response

import android.os.Parcelable
import app.vazovsky.myhome.data.network.model.DoorData
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName

@Parcelize
class DoorsResponse(
    @SerialName("success") val success: Boolean?,
    @SerialName("data") val data: List<DoorData>?,
) : Parcelable