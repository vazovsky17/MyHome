package app.vazovsky.myhome.domain.mapper

import app.vazovsky.myhome.data.network.model.response.DoorsResponse
import app.vazovsky.myhome.domain.extensions.orDefault
import app.vazovsky.myhome.domain.model.Door
import app.vazovsky.myhome.domain.model.DoorList
import javax.inject.Inject

class DoorMapper @Inject constructor() {
    fun fromApiToModel(apiModel: DoorsResponse): DoorList {
        return DoorList(
            success = apiModel.success.orDefault(),
            doors = apiModel.data.orEmpty().map { fromApiToModel(it) },
        )
    }

    private fun fromApiToModel(apiModel: DoorsResponse.DoorData?): Door {
        return Door(
            id = apiModel?.id.orDefault(),
            name = apiModel?.name.orDefault(),
            room = apiModel?.room.orDefault(),
            favorites = apiModel?.favorites.orDefault()
        )
    }
}