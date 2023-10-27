package com.mustafaozt.retrofitapiexample.util

import com.mustafaozt.retrofitapiexample.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getInstance() = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
val api:ApiService by lazy {
    getInstance().create(ApiService::class.java)
}
}