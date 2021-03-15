package com.regera.aad.data.repository

import com.regera.aad.data.models.Albums
import com.regera.aad.data.services.RetrofitInstance
import retrofit2.Response

class AlbumRepository {
    suspend fun getAlbums(): Response<Albums> {
        return RetrofitInstance.api.getAlbums()
    }
}