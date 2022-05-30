package uz.gita.memoryGame.domain.repository

import uz.gita.memoryGame.data.comman.model.LevelData

interface LevelRepository {
    suspend fun loadLevelList():List<LevelData>
}