package uz.gita.memoryGame.data.comman.model

import uz.gita.memoryGame.data.comman.enumclas.TypeEnum
import java.io.Serializable

data class TypeData(
    val id: Int,
    val image: Int,
    val type: TypeEnum
) : Serializable