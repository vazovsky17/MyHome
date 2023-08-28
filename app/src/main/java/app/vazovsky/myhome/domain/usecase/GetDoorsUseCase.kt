package app.vazovsky.myhome.domain.usecase

import app.vazovsky.myhome.data.repository.DoorRepository
import app.vazovsky.myhome.domain.model.DoorList
import app.vazovsky.myhome.domain.usecase.base.UseCase
import app.vazovsky.myhome.domain.usecase.base.UseCaseUnary
import javax.inject.Inject

/** Получение дверей */
class GetDoorsUseCase @Inject constructor(
    private val doorRepository: DoorRepository,
) : UseCaseUnary<UseCase.None, DoorList>() {
    override suspend fun execute(params: UseCase.None): DoorList {
        return doorRepository.getDoors()
    }
}