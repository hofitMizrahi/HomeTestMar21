package com.hofit.hofitcellcomtest.di.components

import com.hofit.hofitcellcomtest.di.modules.DashboardModule
import com.hofit.hofitcellcomtest.di.scope.PerActivity
import com.hofit.hofitcellcomtest.ui.flow.dashboard.view.DashboardActivity
import dagger.Component

@Component(modules = [DashboardModule::class], dependencies = [ApplicationComponent::class])
@PerActivity
interface DashboardComponent {

    fun inject(activity : DashboardActivity)
}