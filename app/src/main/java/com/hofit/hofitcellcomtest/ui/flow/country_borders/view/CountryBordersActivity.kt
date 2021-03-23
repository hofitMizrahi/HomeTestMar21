package com.hofit.hofitcellcomtest.ui.flow.country_borders.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hofit.hofitcellcomtest.R
import com.hofit.hofitcellcomtest.application.ApplicationCellcom
import com.hofit.hofitcellcomtest.di.components.DaggerCountryBordersComponent
import com.hofit.hofitcellcomtest.di.modules.CountryBordersModule
import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.ui.base.BaseActivity
import com.hofit.hofitcellcomtest.ui.base.BasePresenter
import com.hofit.hofitcellcomtest.ui.flow.country_borders.contract.CountryBordersContract
import com.hofit.hofitcellcomtest.ui.flow.country_borders.presenter.CountryBordersPresenter
import com.hofit.hofitcellcomtest.ui.flow.dashboard.view.adapter.CountriesAdapter
import kotlinx.android.synthetic.main.activity_contry_borders.*
import javax.inject.Inject

class CountryBordersActivity : BaseActivity(), CountryBordersContract.View {

    companion object{
        const val COUNTRY_KEY = "COUNTRY_KEY"
    }

    @Inject
    lateinit var mPresenter: CountryBordersPresenter

    @Inject
    lateinit var mAdapter: CountriesAdapter

    override fun initDependencies() {
        DaggerCountryBordersComponent.builder().applicationComponent(ApplicationCellcom.applicationComponent)
            .countryBordersModule(CountryBordersModule(this))
            .build()
            .inject(this)
    }

    override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_contry_borders
    }

    override fun initViews() {
    }

    override fun displayBordersCountriesList(data: List<Country>?) {
        bordersRecyclerView?.layoutManager = LinearLayoutManager(this)
        mAdapter.setData(data, null)
        bordersRecyclerView?.adapter = mAdapter
    }
}