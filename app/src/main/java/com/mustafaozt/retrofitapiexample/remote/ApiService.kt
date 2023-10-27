package com.mustafaozt.retrofitapiexample.remote

import com.mustafaozt.retrofitapiexample.model.Message
import com.mustafaozt.retrofitapiexample.model.MessageList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface  ApiService
{
    @GET("posts/1")
    suspend fun getPostOne():Message
}



