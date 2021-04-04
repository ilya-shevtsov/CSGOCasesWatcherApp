package com.example.csgocaseswatcherapp.core.di.module

import com.example.csgocaseswatcherapp.core.di.module.viewmodel.ViewModelModule
import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        DataModule::class
    ]
)
interface AppModule