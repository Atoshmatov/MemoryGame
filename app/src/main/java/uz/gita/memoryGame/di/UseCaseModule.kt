package uz.gita.memoryGame.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.memoryGame.domain.usecase.*
import uz.gita.memoryGame.domain.usecase.impl.*


@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindSplashUseCase(impl: SplashUseCaseImpl): SplashUseCase

    @Binds
    fun bindHomeUseCase(impl: HomeUseCaseImpl): HomeUseCase

    @Binds
    fun bindGameUseCase(impl: GameUseCaseImpl): GameUseCase

    @Binds
    fun bindLevelUseCase(impl: LevelUseCaseImpl): LevelUseCase

    @Binds
    fun bindTypeUseCase(impl: TypeUseCaseImpl): TypeUseCase
}
