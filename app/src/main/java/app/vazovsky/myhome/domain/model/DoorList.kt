package app.vazovsky.myhome.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoorList(
    val success: Boolean,
    val rooms: List<DoorRoom>,
) : Parcelable