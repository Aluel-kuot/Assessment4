package com.aluel.assessment4.Repository

import com.aluel.assessment4.ApIs.ApiInterface
import com.aluel.assessment4.ApIs.ApiPosts
import com.aluel.assessment4.Models.Posts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepo{
    private val apiClient = ApiPosts.buildClient(ApiInterface::class.java)
    suspend fun getPosts():Response<List<Posts>>{
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
        }
    }
}