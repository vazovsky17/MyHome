package app.vazovsky.myhome.data.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName

@Parcelize
class DoorData(
    @SerialName("name") val name: String?,
    @SerialName("room") val room: String?,
    @SerialName("id") val id: Int?,
    @SerialName("favorites") val favorites: Boolean?,
) : Parcelable