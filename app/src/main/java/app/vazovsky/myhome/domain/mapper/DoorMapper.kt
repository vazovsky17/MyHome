package app.vazovsky.myhome.domain.mapper

import app.vazovsky.myhome.data.network.model.response.DoorsResponse
import app.vazovsky.myhome.domain.extensions.orDefault
import app.vazovsky.myhome.domain.model.Door
import app.vazovsky.myhome.domain.model.DoorList
import app.vazovsky.myhome.domain.model.DoorRoom
import javax.inject.Inject

class DoorMapper @Inject constructor() {
    fun fromApiToModel(apiModel: DoorsResponse): DoorList {
        return DoorList(
            success = apiModel.success.orDefault(),
            rooms = fromMapToList(apiModel.data.orEmpty().groupBy { it.room ?: "UNGROUP" }),
        )
    }

    private fun fromMapToList(map: Map<String, List<DoorsResponse.DoorData>>): List<DoorRoom> {
        val rooms = mutableListOf<DoorRoom>()
        for (item in map.keys) {
            val cameraRoom = DoorRoom(name = item, doors = map[item].orEmpty().map { fromApiToModel(it) })
            rooms.add(cameraRoom)
        }
        return rooms
    }

    private fun fromApiToModel(apiModel: DoorsResponse.DoorData?): Door {
        return Door(
            id = apiModel?.id.orDefault(),
            name = apiModel?.name.orDefault(),
            room = apiModel?.room.orDefault(),
            snapshotUrl = apiModel?.snapshotUrl,
            isFavorite = apiModel?.favorites.orDefault()
        )
    }
}