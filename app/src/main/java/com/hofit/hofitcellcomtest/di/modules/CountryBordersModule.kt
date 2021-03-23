package com.hofit.hofitcellcomtest.di.modules

import com.hofit.hofitcellcomtest.di.scope.PerActivity
import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.ui.flow.country_borders.contract.CountryBordersContract
import com.hofit.hofitcellcomtest.ui.flow.country_borders.view.CountryBordersActivity.Companion.COUNTRY_KEY
import com.hofit.hofitcellcomtest.ui.flow.dashboard.view.adapter.CountriesAdapter
import dagger.Module
import dagger.Provides

@Module
class CountryBordersModule (var mView : CountryBordersContract.View) {

    @PerActivity
    @Provides
    fun provideView() : CountryBordersContract.View{
        return mView
    }

    @PerActivity
    @Provides
    fun provideCountry() : Country{
        return mView.getActivity().intent.getSerializableExtra(COUNTRY_KEY) as Country
    }

    @PerActivity
    @Provides
    fun provideAdapter() : CountriesAdapter {
        return CountriesAdapter()
    }
}