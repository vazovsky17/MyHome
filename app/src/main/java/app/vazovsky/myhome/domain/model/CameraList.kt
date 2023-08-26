package app.vazovsky.myhome.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CameraList(
    val success: Boolean,
    val rooms: List<String>,
    val cameras: List<Camera>,
) : Parcelable