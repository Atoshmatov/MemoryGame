package uz.gita.memoryGame.domain.repository

import uz.gita.memoryGame.data.comman.enumclas.LevelEnum
import uz.gita.memoryGame.data.comman.enumclas.TypeEnum
import uz.gita.memoryGame.data.comman.model.GameData

interface GameRepository {
    suspend fun getDataByLeve(level: LevelEnum, type: TypeEnum): List<GameData>
}