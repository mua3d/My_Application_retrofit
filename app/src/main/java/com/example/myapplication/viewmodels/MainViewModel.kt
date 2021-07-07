package com.example.myapplication.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.Item
import com.example.myapplication.repositries.MainRepository
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val itemList = MutableLiveData<List<Item>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllItem(){

        val response = repository.getAllItem()
        response.enqueue(object : retrofit2.Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                itemList.postValue(response.body())
                Log.i("MainViewModel",response.body().toString())

            }

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                errorMessage.postValue(t.message)

            }
        })
    }
}