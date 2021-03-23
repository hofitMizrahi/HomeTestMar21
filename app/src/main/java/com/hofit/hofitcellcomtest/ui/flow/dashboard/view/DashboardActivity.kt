package com.hofit.hofitcellcomtest.ui.flow.dashboard.view

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.hofit.hofitcellcomtest.R
import com.hofit.hofitcellcomtest.application.ApplicationCellcom
import com.hofit.hofitcellcomtest.di.components.DaggerDashboardComponent
import com.hofit.hofitcellcomtest.di.modules.DashboardModule
import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.ui.base.BaseActivity
import com.hofit.hofitcellcomtest.ui.base.BasePresenter
import com.hofit.hofitcellcomtest.ui.flow.country_borders.view.CountryBordersActivity
import com.hofit.hofitcellcomtest.ui.flow.country_borders.view.CountryBordersActivity.Companion.COUNTRY_KEY
import com.hofit.hofitcellcomtest.ui.flow.dashboard.contract.DashboardContract
import com.hofit.hofitcellcomtest.ui.flow.dashboard.presenter.DashboardPresenter
import com.hofit.hofitcellcomtest.ui.flow.dashboard.view.adapter.CountriesAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject

class DashboardActivity : BaseActivity(), DashboardContract.View {

    @Inject
    lateinit var mPresenter: DashboardPresenter

    @Inject
    lateinit var mAdapter: CountriesAdapter

    override fun initDependencies() {
        DaggerDashboardComponent.builder().applicationComponent(ApplicationCellcom.applicationComponent)
            .dashboardModule(DashboardModule(this))
            .build()
            .inject(this)
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_dashboard
    }

    override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }

    override fun displayCitiesList(data: List<Country>?) {
        countriesRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.setData(data, mPresenter)
        countriesRecyclerView.adapter = mAdapter
    }

    override fun navigateToCountryBordersScreen(country : Country) {
        startActivity(Intent(this, CountryBordersActivity::class.java).putExtra(COUNTRY_KEY, country))
    }

    override fun setListData(list: List<Country>) {
        mAdapter.refreshData(list)
        mAdapter.notifyDataSetChanged()
    }

    override fun initViews() {
        radioGroup.setOnCheckedChangeListener { _ , radioNumber ->
            mPresenter.changeListOrder(radioNumber)
        }
    }
}