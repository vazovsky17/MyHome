package app.vazovsky.myhome.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoorRoom(
    val name: String,
    val doors: List<Door>,
) : Parcelable