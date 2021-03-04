package ru.zmeytee.simpleproject.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.zmeytee.simpleproject.repositories.PersonsRepository
import ru.zmeytee.simpleproject.repositories.PersonsRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class PersonsRepositoryModule {

    @Binds
    abstract fun providePersonRepository(impl: PersonsRepositoryImpl): PersonsRepository
}