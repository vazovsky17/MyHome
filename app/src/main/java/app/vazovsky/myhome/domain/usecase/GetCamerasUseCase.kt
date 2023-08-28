package app.vazovsky.myhome.domain.usecase

import app.vazovsky.myhome.data.repository.CameraRepository
import app.vazovsky.myhome.domain.model.CameraList
import app.vazovsky.myhome.domain.usecase.base.UseCase
import app.vazovsky.myhome.domain.usecase.base.UseCaseUnary
import javax.inject.Inject

/** Получение камер */
class GetCamerasUseCase @Inject constructor(
    private val cameraRepository: CameraRepository,
) : UseCaseUnary<UseCase.None, CameraList>() {
    override suspend fun execute(params: UseCase.None): CameraList {
        return cameraRepository.getCameras()
    }
}