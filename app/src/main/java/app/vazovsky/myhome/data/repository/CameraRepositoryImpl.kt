package app.vazovsky.myhome.data.repository

import app.vazovsky.myhome.data.network.MyHomeApiService
import app.vazovsky.myhome.domain.mapper.CameraMapper
import app.vazovsky.myhome.domain.model.CameraList
import javax.inject.Inject

class CameraRepositoryImpl @Inject constructor(
    private val apiService: MyHomeApiService,
    private val cameraMapper: CameraMapper,
) : CameraRepository {
    override suspend fun getCameras(): CameraList {
        return apiService.getCameras().let(cameraMapper::fromApiToModel)
    }
}