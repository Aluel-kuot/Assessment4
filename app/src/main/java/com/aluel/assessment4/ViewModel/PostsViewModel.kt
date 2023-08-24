package com.aluel.assessment4.ViewModel

import android.content.ClipData.Item
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aluel.assessment4.Models.Posts
import com.aluel.assessment4.Repository.PostsRepo
import kotlinx.coroutines.launch

class PostsViewModel:ViewModel() {
    private val postsRepo = PostsRepo()
    val postsLiveData = MutableLiveData<Posts>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchPosts() {
        viewModelScope.launch {
            val response = postsRepo.getPosts()
            if (response.isSuccessful) {
                val postsList = response.body() ?: emptyList()

                postsLiveData.postValue(postsList as List<Posts>)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}

private fun <T> MutableLiveData<T>.postValue(ts: List<T>) {

}
