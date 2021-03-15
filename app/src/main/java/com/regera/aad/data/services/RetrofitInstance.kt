package com.regera.aad.data.services

import com.google.gson.GsonBuilder
import com.regera.aad.data.constants.Constants.Companion.BASE_URL
import com.regera.aad.data.models.Albums
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    companion object{
        private val retrofit by lazy {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()


            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api:AlbumInterface by lazy {
            retrofit.create(AlbumInterface::class.java)
        }
    }
}