package com.hofit.hofitcellcomtest.repository

import com.hofit.hofitcellcomtest.repository.models.Country
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("all")
    suspend fun getAllCountries(): List<Country>?

    @GET("alpha")
    suspend fun getBordersCountries(@Query("codes") codes : String): List<Country>?
}