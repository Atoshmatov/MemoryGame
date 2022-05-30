package uz.gita.memoryGame.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.memoryGame.data.comman.enumclas.LevelEnum
import uz.gita.memoryGame.data.comman.enumclas.TypeEnum
import uz.gita.memoryGame.data.comman.model.GameData
import uz.gita.memoryGame.domain.repository.impl.GameRepositoryImpl
import uz.gita.memoryGame.domain.usecase.GameUseCase
import javax.inject.Inject

class GameUseCaseImpl
@Inject constructor(
    private val gameRepositoryImpl: GameRepositoryImpl
) : GameUseCase {
    override fun getAllDataByLevel(level: LevelEnum, type: TypeEnum) = flow<List<GameData>> {
        val list = ArrayList<GameData>()
        val l = gameRepositoryImpl.getDataByLeve(level, type)
        list.addAll(l)
        list.addAll(l)
        list.shuffle()
        emit(list)
    }.flowOn(Dispatchers.IO)
}