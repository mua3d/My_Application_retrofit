package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.adapter.MainAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.repositries.MainRepository
import com.example.myapplication.retrofit.RetrofitService
import com.example.myapplication.viewmodels.MainViewModel
import com.example.myapplication.viewmodels.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter


        viewModel.itemList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setItemList(it)
        })
        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllItem()

    }
}