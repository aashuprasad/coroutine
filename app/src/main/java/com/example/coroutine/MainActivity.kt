package com.example.coroutine

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val TAG: String = "KOTLIN_DEBUG"
    lateinit var counterText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }
    }

    suspend fun task1() {
        Log.d(TAG, "STARTING TASK 1")
        delay(3000)
        Log.d(TAG, "ENDING TASK 1")
    }

    suspend fun task2() {
        Log.d(TAG, "STARTING TASK 2")
        delay(2500)
        Log.d(TAG, "ENDING TASK 2")
    }

}