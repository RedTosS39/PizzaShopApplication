package com.example.pizzashopapplication.data

import com.example.pizzashopapplication.data.model.DishesList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getDishes(): DishesList

    companion object {
        private const val DISHES_BASE_URL = "https://run.mocky.io/v3/"
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client: OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(DISHES_BASE_URL)
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}