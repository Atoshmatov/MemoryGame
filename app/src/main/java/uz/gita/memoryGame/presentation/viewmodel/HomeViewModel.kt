package uz.gita.memoryGame.presentation.viewmodel

import androidx.lifecycle.LiveData

interface HomeViewModel {
    //event
    val openLevelScreenLiveData: LiveData<Unit>

    //action
    fun openLevelScreen()
}