package com.example.pizzashopapplication.di.modules

import com.example.pizzashopapplication.constants.Constants.DISHES_BASE_URL
import com.example.pizzashopapplication.data.ApiService
import com.example.pizzashopapplication.di.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @ApplicationScope
    @Provides
    fun provideApiService(): ApiService {

        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()


        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(DISHES_BASE_URL)
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}