package uz.gita.memoryGame.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.memoryGame.data.comman.model.TypeData

interface TypeUseCase {
    fun loadAllType(): Flow<List<TypeData>>
}