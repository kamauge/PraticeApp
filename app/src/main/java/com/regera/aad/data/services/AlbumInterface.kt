package com.regera.aad.data.services

import com.regera.aad.data.models.Albums
import retrofit2.Response
import retrofit2.http.GET

interface AlbumInterface {

    @GET("albums")
    suspend fun getAlbums():Response<Albums>
}