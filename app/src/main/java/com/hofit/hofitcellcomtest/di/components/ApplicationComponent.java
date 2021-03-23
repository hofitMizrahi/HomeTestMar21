package com.hofit.hofitcellcomtest.di.components;

import com.hofit.hofitcellcomtest.application.ApplicationCellcom;
import com.hofit.hofitcellcomtest.di.modules.NetworkModule;
import com.hofit.hofitcellcomtest.di.modules.ApplicationModule;
import com.hofit.hofitcellcomtest.di.scope.PerApplication;
import com.hofit.hofitcellcomtest.repository.RepositoryController;
import com.hofit.hofitcellcomtest.repository.RestApi;
import com.hofit.hofitcellcomtest.ui.base.BaseActivity;

import dagger.Component;

@PerApplication
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(ApplicationCellcom applicationCellcom);

    RepositoryController provideController();

    RestApi restApi();

    void inject(BaseActivity activity);

}
