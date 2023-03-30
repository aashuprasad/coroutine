package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG:String = "KOTLIN_DEBUG"
    lateinit var counterText : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterText = findViewById(R.id.counter)
        Log.d(TAG, "${Thread.currentThread().name}")
    }

    fun updateCounter(view: View) {
        counterText.text = "${counterText.text.toString().toInt() + 1}"
        Log.d(TAG, "${Thread.currentThread().name}")
    }

    fun executeLongRunningTask() {
        for (i in 1..1000000000L){

        }
    }

    fun doAction(view: View) {
        /*//disadvantage - limited os level threads available and difficult context switching
        thread(start = true) {
            executeLongRunningTask()
        }
*/
        //Logcat filter - "package:mine level:debug tag:KOTLIN_DEBUG"
        CoroutineScope(Dispatchers.IO).launch{
            Log.d(TAG, "1- ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "2- ${Thread.currentThread().name}")
        }

        MainScope().launch(Dispatchers.Default){
            Log.d(TAG, "3- ${Thread.currentThread().name}")
        }
    }


}