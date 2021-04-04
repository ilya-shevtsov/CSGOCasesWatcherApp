package com.example.csgocaseswatcherapp.core.di

import com.example.csgocaseswatcherapp.core.di.module.AppModule
import com.example.csgocaseswatcherapp.presentation.view.fragments.casedetails.CaseDetailsFragment
import com.example.csgocaseswatcherapp.presentation.view.fragments.casepreview.CasePreviewFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(fragment: CasePreviewFragment)

    fun inject(fragment: CaseDetailsFragment)
}