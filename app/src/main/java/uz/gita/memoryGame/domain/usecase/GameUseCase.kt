package uz.gita.memoryGame.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.memoryGame.data.comman.enumclas.LevelEnum
import uz.gita.memoryGame.data.comman.enumclas.TypeEnum
import uz.gita.memoryGame.data.comman.model.GameData

interface GameUseCase {
    fun getAllDataByLevel(level: LevelEnum, type: TypeEnum): Flow<List<GameData>>
}