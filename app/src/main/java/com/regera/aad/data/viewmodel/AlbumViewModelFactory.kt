package com.regera.aad.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.regera.aad.data.repository.AlbumRepository

class AlbumViewModelFactory(private val repository: AlbumRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumViewModel(repository) as T
    }
}