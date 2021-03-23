package com.hofit.hofitcellcomtest.ui.flow.country_borders.presenter

import android.util.Log
import com.hofit.hofitcellcomtest.di.scope.PerActivity
import com.hofit.hofitcellcomtest.repository.RepositoryController
import com.hofit.hofitcellcomtest.repository.ResultWrapper
import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.ui.flow.country_borders.contract.CountryBordersContract
import com.hofit.hofitcellcomtest.ui.flow.dashboard.presenter.DashboardPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@PerActivity
class CountryBordersPresenter  @Inject constructor() : CountryBordersContract.Presenter {

    @Inject
    lateinit var mView: CountryBordersContract.View

    @Inject
    lateinit var mRepositoryController: RepositoryController

    @Inject
    lateinit var mCountry: Country

    override fun onStart() {
        mView.displayProgressBar()
        loadBordersData()
    }

    private fun loadBordersData() {

        CoroutineScope(IO).launch {
            val result = mRepositoryController.getBordersCountries(mCountry.getBordersList())

            withContext(Dispatchers.Main) {
                result.let { result ->

                    when (result) {
                        is ResultWrapper.Success -> {
                            mView.displayBordersCountriesList(result.value)
                            Log.i(DashboardPresenter.TAG, "Http 200")
                        }
                        is Error -> {
                            Log.i(DashboardPresenter.TAG, result.message ?: "Http Error")
                        }
                        else -> {
                            Log.i(DashboardPresenter.TAG, "GenericError")
                        }
                    }
                }
                mView.hideProgressbar()
            }
        }
    }
}