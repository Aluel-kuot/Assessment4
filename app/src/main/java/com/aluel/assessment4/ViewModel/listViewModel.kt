package com.aluel.assessment4.ViewModel

import android.content.ClipData.Item
import androidx.lifecycle.MutableLiveData
import com.aluel.assessment4.Repository.ListRepo

class listViewModel {

    val lisRepo = ListRepo()
    val listLiveData = MutableLiveData<List<Item>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchItems(){
        viewModelScope.launch {
            val response = lisRepo.getList()
            if(response.isSuccessful){
                listLiveData.postValue(response.body()?.items)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }

