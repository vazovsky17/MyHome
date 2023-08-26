package app.vazovsky.myhome.data.repository

import app.vazovsky.myhome.data.network.MyHomeApiService
import app.vazovsky.myhome.domain.mapper.DoorMapper
import app.vazovsky.myhome.domain.model.DoorList
import javax.inject.Inject

class DoorRepositoryImpl @Inject constructor(
    private val apiService: MyHomeApiService,
    private val doorMapper: DoorMapper,
) : DoorRepository {
    override suspend fun getDoors(): DoorList {
        return apiService.getDoors().let(doorMapper::fromApiToModel)
    }
}