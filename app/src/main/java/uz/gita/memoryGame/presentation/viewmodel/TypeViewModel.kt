package uz.gita.memoryGame.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.memoryGame.data.comman.model.TypeData

interface TypeViewModel {
    val typeLiveData: LiveData<List<TypeData>>

    fun loadTypeList()
}