package uz.gita.memoryGame.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.memoryGame.data.comman.model.LevelData

interface LevelViewModel {
    val levelLiveData: LiveData<List<LevelData>>

    fun loadLevelList()
}