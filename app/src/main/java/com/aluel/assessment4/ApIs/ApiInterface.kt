package com.aluel.assessment4.ApIs

import com.aluel.assessment4.Models.ListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/items")
    suspend fun getItems():Response<ListResponse>
}


