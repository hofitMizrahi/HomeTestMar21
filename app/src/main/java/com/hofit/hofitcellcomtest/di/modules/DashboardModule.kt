package com.hofit.hofitcellcomtest.di.modules

import com.hofit.hofitcellcomtest.di.scope.PerActivity
import com.hofit.hofitcellcomtest.ui.flow.dashboard.contract.DashboardContract
import com.hofit.hofitcellcomtest.ui.flow.dashboard.view.adapter.CountriesAdapter
import dagger.Module
import dagger.Provides

@Module
class DashboardModule (var mView : DashboardContract.View) {

    @PerActivity
    @Provides
    fun provideView() : DashboardContract.View{
        return mView
    }

    @PerActivity
    @Provides
    fun provideAdapter() : CountriesAdapter {
        return CountriesAdapter()
    }
}
