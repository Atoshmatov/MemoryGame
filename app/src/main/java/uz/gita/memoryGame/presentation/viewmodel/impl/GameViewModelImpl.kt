package uz.gita.memoryGame.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.memoryGame.data.comman.enumclas.LevelEnum
import uz.gita.memoryGame.data.comman.enumclas.TypeEnum
import uz.gita.memoryGame.data.comman.model.GameData
import uz.gita.memoryGame.domain.usecase.GameUseCase
import uz.gita.memoryGame.presentation.viewmodel.GameViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModelImpl
@Inject constructor(
    private val gameUseCase: GameUseCase
) : ViewModel(), GameViewModel {
    override val allGameDataLiveData = MutableLiveData<List<GameData>>()

    override fun loadData(level: LevelEnum, type: TypeEnum) {
        gameUseCase.getAllDataByLevel(level,type).onEach {
            allGameDataLiveData.value = it
        }.launchIn(viewModelScope)
    }
}