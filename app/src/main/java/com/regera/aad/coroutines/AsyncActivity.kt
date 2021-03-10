package com.regera.aad.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.regera.aad.R
import com.regera.aad.databinding.ActivityAsyncBinding
import kotlinx.coroutines.*


class AsyncActivity : AppCompatActivity() {

    val TAG = "AsyncActivity"
    private lateinit var binding: ActivityAsyncBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_async)
        binding = ActivityAsyncBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        GlobalScope.launch(Dispatchers.IO) {
            val answer = task()
            withContext(Dispatchers.Main){
                binding.tvCoroutine.text = answer
            }
        }

    }


    suspend fun task() : String{
        return "This is the answer"

    }


}