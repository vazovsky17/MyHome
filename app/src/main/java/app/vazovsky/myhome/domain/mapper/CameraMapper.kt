package app.vazovsky.myhome.domain.mapper

import app.vazovsky.myhome.data.network.model.CameraData
import app.vazovsky.myhome.data.network.model.response.CamerasResponse
import app.vazovsky.myhome.domain.extensions.orDefault
import app.vazovsky.myhome.domain.model.Camera
import app.vazovsky.myhome.domain.model.CameraList
import javax.inject.Inject

class CameraMapper @Inject constructor() {
    fun fromApiToModel(apiModel: CamerasResponse): CameraList {
        return CameraList(success = apiModel.success.orDefault(),
            rooms = apiModel.data?.room.orEmpty(),
            cameras = apiModel.data?.cameras.orEmpty().map { fromApiToModel(it) })
    }

    private fun fromApiToModel(apiModel: CameraData?): Camera {
        return Camera(
            id = apiModel?.id.orDefault(),
            name = apiModel?.name.orDefault(),
            snapshotUrl = apiModel?.snapshotUrl,
            room = apiModel?.room.orDefault(),
            favorites = apiModel?.favorites.orDefault(),
            isRecording = apiModel?.isRecording.orDefault(),
        )
    }
}