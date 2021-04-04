package com.example.csgocaseswatcherapp.core.di.module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.csgocaseswatcherapp.presentation.view.fragments.casepreview.CasePreviewViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ViewModelModule {

    @Binds
    @Singleton
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CasePreviewViewModel::class)
    fun casePreviewViewModel(viewModel: CasePreviewViewModel): ViewModel
}
