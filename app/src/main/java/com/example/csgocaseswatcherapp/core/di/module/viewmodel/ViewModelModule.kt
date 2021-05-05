package com.example.csgocaseswatcherapp.core.di.module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.csgocaseswatcherapp.presentation.view.fragments.casedetails.CaseDetailsViewModel
import com.example.csgocaseswatcherapp.presentation.view.fragments.casepreview.CaseOverviewViewModel
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
    @ViewModelKey(CaseOverviewViewModel::class)
    fun caseOverviewViewModel(viewModel: CaseOverviewViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CaseDetailsViewModel::class)
    fun caseDetailsViewModel(viewModel: CaseDetailsViewModel): ViewModel
}
