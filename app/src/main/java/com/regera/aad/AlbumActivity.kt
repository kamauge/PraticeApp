package com.regera.aad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.regera.aad.data.repository.AlbumRepository
import com.regera.aad.data.viewmodel.AlbumViewModel
import com.regera.aad.data.viewmodel.AlbumViewModelFactory
import com.regera.aad.databinding.ActivityAlbumBinding

class AlbumActivity : AppCompatActivity() {

    private val TAG = "ALBUMACTIVITY"
    private lateinit var albumViewModel: AlbumViewModel
    private lateinit var binding: ActivityAlbumBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlbumBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = AlbumRepository()
        val viewModelFactory = AlbumViewModelFactory(repository)
        albumViewModel = ViewModelProvider(this, viewModelFactory).get(AlbumViewModel::class.java)
        albumViewModel.getAlbum()
        albumViewModel.myResponse.observe(this, Observer { response ->

            if (response.isSuccessful) {
                Log.d(TAG, response.body()?.id.toString())
               Log.d(TAG, response.body()?.userId.toString())
               Log.d(TAG, response.body()?.title!!)
              //  binding.tvTitle.text = response.body()?.title!!
            } else {

                Log.d(TAG,"error")
            }


        })
    }
}