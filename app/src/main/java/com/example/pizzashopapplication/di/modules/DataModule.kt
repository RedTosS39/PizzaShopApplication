package com.example.pizzashopapplication.di.modules

import com.example.pizzashopapplication.data.RepositoryImpl
import com.example.pizzashopapplication.di.ApplicationScope
import com.example.pizzashopapplication.domain.Repository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindListRepository(repositoryImpl: RepositoryImpl) : Repository
}