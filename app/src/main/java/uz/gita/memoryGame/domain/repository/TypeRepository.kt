package uz.gita.memoryGame.domain.repository

import uz.gita.memoryGame.data.comman.model.TypeData

interface TypeRepository {
    suspend fun loadTypeList(): List<TypeData>
}