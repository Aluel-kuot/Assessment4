package com.aluel.assessment4.ApIs

import com.aluel.assessment4.Models.Posts
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
        @GET("/posts")
        suspend fun getPosts():Response<List<Posts>>
}


