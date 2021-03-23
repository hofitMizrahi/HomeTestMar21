package com.hofit.hofitcellcomtest.ui.base

interface BaseView {

    fun initViews()
    fun getActivity() : BaseActivity
    fun displayProgressBar()
    fun hideProgressbar()
}