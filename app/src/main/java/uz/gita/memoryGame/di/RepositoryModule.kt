package uz.gita.memoryGame.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.memoryGame.domain.repository.AppRepository
import uz.gita.memoryGame.domain.repository.GameRepository
import uz.gita.memoryGame.domain.repository.LevelRepository
import uz.gita.memoryGame.domain.repository.TypeRepository
import uz.gita.memoryGame.domain.repository.impl.AppRepositoryImpl
import uz.gita.memoryGame.domain.repository.impl.GameRepositoryImpl
import uz.gita.memoryGame.domain.repository.impl.LevelRepositoryImpl
import uz.gita.memoryGame.domain.repository.impl.TypeRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @[Binds Singleton]
    fun bindAppRepository(impl: AppRepositoryImpl): AppRepository

    @[Binds Singleton]
    fun bindTYpeRepository(impl: TypeRepositoryImpl): TypeRepository

    @[Binds Singleton]
    fun bindLevelRepository(impl: LevelRepositoryImpl): LevelRepository

    @[Binds Singleton]
    fun bindGameRepository(impl: GameRepositoryImpl): GameRepository
}