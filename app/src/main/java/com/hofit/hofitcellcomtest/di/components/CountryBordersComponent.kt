package com.hofit.hofitcellcomtest.di.components

import com.hofit.hofitcellcomtest.di.modules.CountryBordersModule
import com.hofit.hofitcellcomtest.di.scope.PerActivity
import com.hofit.hofitcellcomtest.ui.flow.country_borders.view.CountryBordersActivity
import dagger.Component

@PerActivity
@Component(modules = [CountryBordersModule::class], dependencies = [ApplicationComponent::class])
interface CountryBordersComponent {

    fun inject(countryBordersActivity: CountryBordersActivity)
}