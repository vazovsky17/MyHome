package app.vazovsky.myhome.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Door(
    val id: Int,
    val name: String,
    val room: String,
    val snapshotUrl: String?,
    val isFavorite: Boolean,
) : Parcelable