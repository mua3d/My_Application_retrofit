package com.example.myapplication.retrofit

import com.example.myapplication.models.Item
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("f6a04152-7e32-413c-a582-e38122ac3106")
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