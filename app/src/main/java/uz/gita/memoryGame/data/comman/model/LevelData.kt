package uz.gita.memoryGame.data.comman.model

import uz.gita.memoryGame.data.comman.enumclas.LevelEnum
import java.io.Serializable

data class LevelData(
    val id: Int,
    val image: Int,
    val count: String,
    val level:LevelEnum
) : Serializable