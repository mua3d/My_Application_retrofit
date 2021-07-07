package com.example.myapplication.models

import retrofit2.http.Url

data class Item(
    val title: String,
    val description: String,
    val imageUrl: String
)
