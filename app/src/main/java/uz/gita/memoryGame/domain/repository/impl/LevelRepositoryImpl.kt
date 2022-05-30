package uz.gita.memoryGame.domain.repository.impl

import uz.gita.memoryGame.R
import uz.gita.memoryGame.data.comman.enumclas.LevelEnum
import uz.gita.memoryGame.data.comman.model.LevelData
import uz.gita.memoryGame.domain.repository.LevelRepository
import javax.inject.Inject

class LevelRepositoryImpl @Inject constructor() : LevelRepository {

    private var leveListData = ArrayList<LevelData>()

    init {
        addList()
    }

    private fun addList() {
        leveListData = ArrayList()
        leveListData.add(LevelData(0, R.drawable.beginner, "2 x 3", LevelEnum.BEGINNER))
        leveListData.add(LevelData(1, R.drawable.easy, "3 x 4", LevelEnum.EASY))
        leveListData.add(LevelData(2, R.drawable.medium, "4 x 4", LevelEnum.MEDIUM))
        leveListData.add(LevelData(3, R.drawable.hard, "6 x 4", LevelEnum.HARD))
        leveListData.add(LevelData(4, R.drawable.hardest, "6 x 5", LevelEnum.HARDEST))
        leveListData.add(LevelData(5, R.drawable.master, "8 x 6", LevelEnum.MASTER))
    }

    override suspend fun loadLevelList(): List<LevelData> = leveListData
}