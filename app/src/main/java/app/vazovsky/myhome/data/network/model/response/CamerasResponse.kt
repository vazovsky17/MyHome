package app.vazovsky.myhome.data.network.model.response

import android.os.Parcelable
import app.vazovsky.myhome.data.network.model.CamerasListData
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName

@Parcelize
class CamerasResponse(
    @SerialName("success") val success: Boolean?,
    @SerialName("data") val data: CamerasListData?,
) : Parcelable