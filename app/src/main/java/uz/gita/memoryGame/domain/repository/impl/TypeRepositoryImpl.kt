package uz.gita.memoryGame.domain.repository.impl

import uz.gita.memoryGame.R
import uz.gita.memoryGame.data.comman.enumclas.TypeEnum
import uz.gita.memoryGame.data.comman.model.TypeData
import uz.gita.memoryGame.domain.repository.TypeRepository
import javax.inject.Inject

class TypeRepositoryImpl @Inject constructor() : TypeRepository {
    private var typeListData = ArrayList<TypeData>()
    init {
        addList()
    }

    private fun addList() {
        typeListData = ArrayList()
        typeListData.add(TypeData(0, R.drawable.category_1, TypeEnum.ALPHABET))
        typeListData.add(TypeData(1, R.drawable.category_2, TypeEnum.ANIMALS))
        typeListData.add(TypeData(2, R.drawable.category_3, TypeEnum.FRUIT))
        typeListData.add(TypeData(3, R.drawable.category_4, TypeEnum.TOYS))
        typeListData.add(TypeData(4, R.drawable.category_5, TypeEnum.BIRDS))
        typeListData.add(TypeData(5, R.drawable.category_6, TypeEnum.U))
        typeListData.add(TypeData(6, R.drawable.category_7, TypeEnum.ANIM))
        typeListData.add(TypeData(7, R.drawable.category_8, TypeEnum.MONSTER))
        typeListData.add(TypeData(8, R.drawable.category_9, TypeEnum.EMOJI))
    }

    override suspend fun loadTypeList(): List<TypeData> = typeListData

}