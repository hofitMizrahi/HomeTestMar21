package com.hofit.hofitcellcomtest.application

import android.app.Application
import com.hofit.hofitcellcomtest.di.components.ApplicationComponent
import com.hofit.hofitcellcomtest.di.components.DaggerApplicationComponent
import com.hofit.hofitcellcomtest.di.modules.NetworkModule
import com.hofit.hofitcellcomtest.di.modules.ApplicationModule

class ApplicationCellcom : Application() {

    companion object{
        var applicationComponent: ApplicationComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        initDependency()
    }

    private fun initDependency(){
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        }
    }
}