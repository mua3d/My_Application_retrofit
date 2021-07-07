package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.repositries.MainRepository
import java.lang.IllegalArgumentException


// We can not create ViewModel on our own. We need ViewModelProviders utility provided by Android to create ViewModels.But ViewModelProviders can only instantiate ViewModels with no arg constructor.So if I have a ViewModel with multiple arguments, then I need to use a Factory that I can pass to ViewModelProviders to use when an instance of MyViewModel is required.


class ViewModelFactory constructor(private val repository: MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel:: class.java)){
                    MainViewModel(this.repository) as T
        } else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}