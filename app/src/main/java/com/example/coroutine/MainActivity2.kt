package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        CoroutineScope(Dispatchers.Main).launch {
            execute()
        }

    }
}

private suspend fun execute(){
    val parentJob = CoroutineScope(Dispatchers.IO).launch {
        for (i in 1..100){
            //check coroutines active state
            if(isActive){
                executeLongRunningTask()
                Log.d("KOTLIN_DEBUG", i.toString())
            }
        }
    }
    delay(100)
    Log.d("KOTLIN_DEBUG", "Cancelling Job")
    parentJob.cancel()

}

fun executeLongRunningTask() {
    for (i in 1..1000000 ){

    }
}
