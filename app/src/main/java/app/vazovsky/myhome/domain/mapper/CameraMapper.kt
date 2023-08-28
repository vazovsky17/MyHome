package app.vazovsky.myhome.domain.mapper

import app.vazovsky.myhome.data.network.model.response.CamerasResponse
import app.vazovsky.myhome.domain.extensions.orDefault
import app.vazovsky.myhome.domain.model.Camera
import app.vazovsky.myhome.domain.model.CameraList
import app.vazovsky.myhome.domain.model.CameraRoom
import javax.inject.Inject

class CameraMapper @Inject constructor() {
    fun fromApiToModel(apiModel: CamerasResponse): CameraList {
        return CameraList(
            success = apiModel.success.orDefault(),
            rooms = fromMapToList(apiModel.data?.cameras.orEmpty().groupBy { it.room ?: "UNGROUP" }),
        )
    }

    private fun fromMapToList(map: Map<String, List<CamerasResponse.CamerasListData.CameraData>>): List<CameraRoom> {
        val rooms = mutableListOf<CameraRoom>()
        for (item in map.keys) {
            val cameraRoom = CameraRoom(name = item, cameras = map[item].orEmpty().map { fromApiToModel(it) })
            rooms.add(cameraRoom)
        }
        return rooms
    }

    private fun fromApiToModel(apiModel: CamerasResponse.CamerasListData.CameraData?): Camera {
        return Camera(
            id = apiModel?.id.orDefault(),
            name = apiModel?.name.orDefault(),
            snapshotUrl = apiModel?.snapshotUrl,
            room = apiModel?.room.orDefault(),
            isFavorite = apiModel?.favorites.orDefault(),
            isRecording = apiModel?.isRecording.orDefault(),
        )
    }
}