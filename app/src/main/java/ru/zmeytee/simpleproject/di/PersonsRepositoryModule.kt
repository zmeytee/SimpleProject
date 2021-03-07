package ru.zmeytee.simpleproject.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.zmeytee.simpleproject.repositories.UsersRepository
import ru.zmeytee.simpleproject.repositories.UsersRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class PersonsRepositoryModule {

    @Binds
    abstract fun providePersonRepository(impl: UsersRepositoryImpl): UsersRepository
}