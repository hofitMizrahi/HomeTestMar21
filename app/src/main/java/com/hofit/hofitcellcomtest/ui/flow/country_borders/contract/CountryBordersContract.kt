package com.hofit.hofitcellcomtest.ui.flow.country_borders.contract

import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.ui.base.BasePresenter
import com.hofit.hofitcellcomtest.ui.base.BaseView
import com.hofit.hofitcellcomtest.ui.flow.country_borders.presenter.CountryBordersPresenter

interface CountryBordersContract {

    interface View : BaseView {
        fun displayBordersCountriesList(data: List<Country>?)
    }

    interface Presenter : BasePresenter<CountryBordersPresenter> {
        }
}