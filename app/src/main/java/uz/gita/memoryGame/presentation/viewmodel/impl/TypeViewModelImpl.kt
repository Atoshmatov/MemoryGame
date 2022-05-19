package uz.gita.memoryGame.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.memoryGame.data.comman.model.TypeData
import uz.gita.memoryGame.domain.usecase.TypeUseCase
import uz.gita.memoryGame.presentation.viewmodel.TypeViewModel
import javax.inject.Inject

@HiltViewModel
class TypeViewModelImpl @Inject constructor(
    private val typeUseCase: TypeUseCase
) : ViewModel(), TypeViewModel {
    override val typeLiveData = MutableLiveData<List<TypeData>>()

    override fun loadTypeList() {
        typeUseCase.loadAllType().onEach {
            typeLiveData.value = it
        }.launchIn(viewModelScope)
    }
}