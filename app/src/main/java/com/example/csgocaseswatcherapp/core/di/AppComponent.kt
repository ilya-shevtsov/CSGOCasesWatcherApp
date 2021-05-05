package com.example.csgocaseswatcherapp.core.di

import com.example.csgocaseswatcherapp.core.di.module.AppModule
import com.example.csgocaseswatcherapp.presentation.view.fragments.caseanalytics.CaseAnalyticsFragment
import com.example.csgocaseswatcherapp.presentation.view.fragments.caseoverviewdetails.CaseDetailsFragment
import com.example.csgocaseswatcherapp.presentation.view.fragments.caseoverview.CaseOverviewFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(fragment: CaseOverviewFragment)

    fun inject(fragment: CaseDetailsFragment)

    fun inject(fragment: CaseAnalyticsFragment)
}