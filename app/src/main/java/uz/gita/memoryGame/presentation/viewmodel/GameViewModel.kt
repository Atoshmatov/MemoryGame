package uz.gita.memoryGame.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.memoryGame.data.comman.enumclas.LevelEnum
import uz.gita.memoryGame.data.comman.enumclas.TypeEnum
import uz.gita.memoryGame.data.comman.model.GameData

interface GameViewModel {
    val allGameDataLiveData: LiveData<List<GameData>>

    fun loadData(level: LevelEnum, type: TypeEnum)
}