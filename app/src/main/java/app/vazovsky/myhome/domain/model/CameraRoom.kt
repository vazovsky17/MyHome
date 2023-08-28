package app.vazovsky.myhome.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CameraRoom (
    val name: String,
    val cameras: List<Camera>,
) : Parcelable