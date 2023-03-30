package com.example.coroutine

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    private val TAG: String = "KOTLIN_DEBUG"
    lateinit var counterText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CoroutineScope(Dispatchers.Unconfined).launch {
            execute()
        }
    }

    private suspend fun execute(){
        val parentJob = GlobalScope.launch(Dispatchers.Main){

            Log.d(TAG, "Parent Started")

            val childJob = launch(Dispatchers.IO){
                try{
                Log.d(TAG, "Child job started")
                delay(3000)
                Log.d(TAG, "Child job ended")
                } catch (e: CancellationException){
                    Log.d(TAG, "Child job cancelled")
                }
            }
            delay(2000)
            childJob.cancel()
            Log.d(TAG, "Parent ended")
        }
        /*delay(1000)
        parentJob.cancel()*/
        parentJob.join()
        Log.d(TAG, "Parent completed")
    }
}