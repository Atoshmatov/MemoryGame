package uz.gita.memoryGame.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.memoryGame.data.comman.model.LevelData

interface LevelUseCase {
    fun loadAllLevel(): Flow<List<LevelData>>
}