package com.regera.aad.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.regera.aad.data.models.Albums
import com.regera.aad.data.repository.AlbumRepository
import kotlinx.coroutines.launch

class AlbumViewModel(private val repository: AlbumRepository) : ViewModel() {

    val myResponse : MutableLiveData<Albums> = MutableLiveData()

    fun getAlbum(){
        viewModelScope.launch {
            val response = repository.getAlbums()

           // myResponse.value.
        }
    }
}