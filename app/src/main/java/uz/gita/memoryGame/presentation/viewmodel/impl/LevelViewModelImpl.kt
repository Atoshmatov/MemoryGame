package uz.gita.memoryGame.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.memoryGame.data.comman.model.LevelData
import uz.gita.memoryGame.domain.usecase.LevelUseCase
import uz.gita.memoryGame.presentation.viewmodel.LevelViewModel
import javax.inject.Inject

@HiltViewModel
class LevelViewModelImpl
@Inject constructor(
    private val levelUseCase: LevelUseCase
) : ViewModel(), LevelViewModel {
    override val levelLiveData = MutableLiveData<List<LevelData>>()

    override fun loadLevelList() {
        levelUseCase.loadAllLevel().onEach {
            levelLiveData.value = it
        }.launchIn(viewModelScope)
    }
}