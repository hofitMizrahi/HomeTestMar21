package com.hofit.hofitcellcomtest.ui.flow.dashboard.presenter

import android.util.Log
import com.hofit.hofitcellcomtest.di.scope.PerActivity
import com.hofit.hofitcellcomtest.repository.RepositoryController
import com.hofit.hofitcellcomtest.repository.ResultWrapper
import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.ui.flow.dashboard.contract.DashboardContract
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Inject

@PerActivity
class DashboardPresenter @Inject constructor() : DashboardContract.Presenter {

    companion object {
        const val TAG = "DashboardPresenter"
    }

    var mCountriesWordsList: List<Country>? = null
    var mCountriesAreaList: List<Country>? = null

    @Inject
    lateinit var mRepositoryController: RepositoryController

    @Inject
    lateinit var mView: DashboardContract.View

    override fun onStart() {
        mView.displayProgressBar()
        mView.initViews()
        loadData()
    }

    override fun execute(country: Country?) {
        country?.let {
            mView.navigateToCountryBordersScreen(it)
        }
    }

    private fun loadData() {

        CoroutineScope(Dispatchers.IO).launch {
            val result = mRepositoryController.getAllCountries()

            withContext(Dispatchers.Main) {
                result.let { result ->

                    when (result) {
                        is ResultWrapper.Success -> {
                            result.value?.let { list ->

                                withContext(Dispatchers.Default) {
                                    mCountriesWordsList =
                                        async { list.sortedBy { it.name } }.await()
                                    mCountriesAreaList = async { list.sortedBy { it.area } }.await()
                                }
                                mView.displayCitiesList(result.value)
                            }
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

    override fun changeListOrder(radioNumber: Int) {
        mView.displayProgressBar()
        when (radioNumber) {
            1 -> {
                mCountriesWordsList?.let {
                    mView.setListData(it)
                }
            }
            2 -> {
                mCountriesWordsList?.let { list ->
                    CoroutineScope(Dispatchers.Default).launch {
                        val reverseList = list.reversed()
                        withContext(Main) {
                            mView.setListData(reverseList)
                        }
                    }
                }
            }
            3 -> {
                mCountriesAreaList?.let {
                    mView.setListData(it)
                }
            }
            else -> {
                mCountriesAreaList?.let { list ->
                    CoroutineScope(Dispatchers.Default).launch {
                        val reverseList = list.reversed()
                        withContext(Main) {
                            mView.setListData(reverseList)
                        }
                    }
                }
            }
        }
        mView.hideProgressbar()
    }
}