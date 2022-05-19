package uz.gita.memoryGame.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.memoryGame.domain.usecase.GameUseCase
import javax.inject.Inject

@HiltViewModel
class GameViewModelImpl @Inject constructor() : ViewModel(), GameUseCase {
}