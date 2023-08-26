package app.vazovsky.myhome.domain.usecase

import app.vazovsky.myhome.data.repository.CameraRepository
import app.vazovsky.myhome.domain.model.CameraList
import javax.inject.Inject

/** Получение камер */
class GetCamerasUseCase @Inject constructor(
    private val cameraRepository: CameraRepository,
) {
    suspend operator fun invoke(): CameraList {
        return cameraRepository.getCameras()
    }
}