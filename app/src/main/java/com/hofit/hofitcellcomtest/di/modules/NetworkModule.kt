package com.hofit.hofitcellcomtest.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hofit.hofitcellcomtest.di.scope.PerApplication
import com.hofit.hofitcellcomtest.repository.RepositoryController
import com.hofit.hofitcellcomtest.repository.RepositoryControllerImp
import com.hofit.hofitcellcomtest.repository.RestApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl("https://restcountries.eu/rest/v2/")
            .client(httpClient)
            .build()
    }

    @Provides
    @PerApplication
    fun provideRestApi(retrofit: Retrofit): RestApi {
        return retrofit.create(RestApi::class.java)
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    fun provideRepository(repositoryImp : RepositoryControllerImp) : RepositoryController{
        return repositoryImp
    }
}