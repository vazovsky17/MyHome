package app.vazovsky.myhome.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Camera(
    val id: Int,
    val name: String,
    val snapshotUrl: String?,
    val room: String,
    val isFavorite: Boolean,
    val isRecording: Boolean,
) : Parcelable