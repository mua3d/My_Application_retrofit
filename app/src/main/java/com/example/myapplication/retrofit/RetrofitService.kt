package com.example.myapplication.retrofit

import com.example.myapplication.models.Item
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("70d349b5-c240-4cda-aa18-bc9c860a71a3")
    fun getAllItem(): Call<List<Item>>

    //Retrofit service instance

    companion object{
        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}