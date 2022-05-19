package uz.gita.memoryGame.domain.repository.impl

import uz.gita.memoryGame.R
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
        typeListData.add(TypeData(1, R.drawable.alphabet_theme_star_0))
        typeListData.add(TypeData(2, R.drawable.anim_theme_star_0))
        typeListData.add(TypeData(3, R.drawable.fruit_theme_star_0))
        typeListData.add(TypeData(4, R.drawable.toys_theme_star_0))
        typeListData.add(TypeData(5, R.drawable.birds_theme_star_0))
        typeListData.add(TypeData(6, R.drawable.unicon_theme_star_0))
        typeListData.add(TypeData(7, R.drawable.animals_theme_star_0))
        typeListData.add(TypeData(8, R.drawable.monsters_theme_star_0))
        typeListData.add(TypeData(9, R.drawable.emoji_theme_star_0))
    }

    override suspend fun loadTypeList(): List<TypeData> = typeListData
}