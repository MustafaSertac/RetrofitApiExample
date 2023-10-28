package com.mustafaozt.retrofitapiexample.remote

import com.mustafaozt.retrofitapiexample.model.Message
import com.mustafaozt.retrofitapiexample.model.MessageList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface  ApiService
{
    @GET("posts/1")
    suspend fun getPostOne():Message
    @GET("/comments")
    suspend fun getPostList(@Query("postId")  postId:String) :Response<MessageList>

    @POST("posts")
    suspend fun pushPost(
        @Body post: Message
    ): Response<Message>

    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Response<Message>

}



