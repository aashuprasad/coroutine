package com.example.coroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val TAG:String = "KOTLIN_DEBUG"

    init {
        viewModelScope.launch {
            while (true){
                delay(500)
                Log.d(TAG, "I cant STOOOOOOOOP")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel destroyed")
    }
}