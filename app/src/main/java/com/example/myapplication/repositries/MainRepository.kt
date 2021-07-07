package com.example.myapplication.repositries

import com.example.myapplication.retrofit.RetrofitService

//the repository class will pass the retrofit service to perform the network call

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllItem() = retrofitService.getAllItem()
}