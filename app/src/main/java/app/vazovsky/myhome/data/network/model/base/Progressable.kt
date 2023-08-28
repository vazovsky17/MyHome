package app.vazovsky.myhome.data.network.model.base

interface Progressable<T> {
    val isInProgress: Boolean

    fun updateProgress(inProgress: Boolean): T
}