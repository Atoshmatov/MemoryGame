package uz.gita.memoryGame.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.memoryGame.data.comman.model.TypeData
import uz.gita.memoryGame.domain.repository.TypeRepository
import uz.gita.memoryGame.domain.usecase.TypeUseCase
import javax.inject.Inject

class TypeUseCaseImpl
@Inject constructor(
    private val typeRepository: TypeRepository
) : TypeUseCase {
    override fun loadAllType() = flow<List<TypeData>> {
        emit(typeRepository.loadTypeList())
    }.flowOn(Dispatchers.IO)

}