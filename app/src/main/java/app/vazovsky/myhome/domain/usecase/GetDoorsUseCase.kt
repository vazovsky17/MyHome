package app.vazovsky.myhome.domain.usecase

import app.vazovsky.myhome.data.repository.DoorRepository
import app.vazovsky.myhome.domain.model.DoorList
import javax.inject.Inject

/** Получение дверей */
class GetDoorsUseCase @Inject constructor(
    private val doorRepository: DoorRepository,
) {
    suspend operator fun invoke(): DoorList {
        return doorRepository.getDoors()
    }
}