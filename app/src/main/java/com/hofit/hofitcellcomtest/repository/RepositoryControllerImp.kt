package com.hofit.hofitcellcomtest.repository

import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.repository.models.ErrorResponse
import com.squareup.moshi.Moshi
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RepositoryControllerImp @Inject constructor() : RepositoryController {

    @Inject
    lateinit var mRestApi: RestApi

    override suspend fun getAllCountries(): ResultWrapper<List<Country>?> {
        return safeApiCall { mRestApi.getAllCountries() }
    }

    override suspend fun getBordersCountries(codes : String): ResultWrapper<List<Country>?> {
        return safeApiCall { mRestApi.getBordersCountries(codes) }
    }

    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultWrapper<T> {
        return try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> ResultWrapper.NetworkError
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    ResultWrapper.GenericError(code, errorResponse)
                }
                else -> {
                    ResultWrapper.GenericError(null, null)
                }
            }
        }
    }

    private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
        return try {
            throwable.response()?.errorBody()?.source()?.let {
                val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (exception: Exception) {
            null
        }
    }
}