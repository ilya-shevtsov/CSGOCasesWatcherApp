package com.example.csgocaseswatcherapp.core.di.module

import com.example.csgocaseswatcherapp.data.repository.CaseRepositoryImpl
import com.example.csgocaseswatcherapp.domain.repository.CaseRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataModule {

    @Binds
    @Singleton
    fun caseRepository(impl: CaseRepositoryImpl): CaseRepository
}