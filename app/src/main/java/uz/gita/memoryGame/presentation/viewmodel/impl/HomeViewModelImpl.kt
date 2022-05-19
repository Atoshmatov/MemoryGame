package uz.gita.memoryGame.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.memoryGame.presentation.viewmodel.HomeViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor() : HomeViewModel, ViewModel() {
    override val openLevelScreenLiveData = MutableLiveData<Unit>()


    override fun openLevelScreen() {
        openLevelScreenLiveData.value = Unit
    }
}