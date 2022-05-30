package uz.gita.memoryGame.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.memoryGame.data.comman.model.LevelData
import uz.gita.memoryGame.domain.repository.LevelRepository
import uz.gita.memoryGame.domain.usecase.LevelUseCase
import javax.inject.Inject


class LevelUseCaseImpl
@Inject constructor(
    private val levelRepository: LevelRepository
) : LevelUseCase {
    override fun loadAllLevel() = flow<List<LevelData>> {
        emit(levelRepository.loadLevelList())
    }.flowOn(Dispatchers.IO)
}