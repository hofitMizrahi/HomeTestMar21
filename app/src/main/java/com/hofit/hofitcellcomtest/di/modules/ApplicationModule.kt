package com.hofit.hofitcellcomtest.di.modules

import android.app.Application
import android.content.Context
import com.hofit.hofitcellcomtest.di.scope.PerApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule (var application: Application){

}