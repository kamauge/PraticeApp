package com.regera.aad.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.regera.aad.data.models.Albums
import com.regera.aad.data.repository.AlbumRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AlbumViewModel(private val albumRepository: AlbumRepository) : ViewModel() {

    val myResponse : MutableLiveData<Response<Albums>> = MutableLiveData()

    fun getAlbum(){
        viewModelScope.launch {
            val response = albumRepository.getAlbum()
            myResponse.value =response
        }
    }
}