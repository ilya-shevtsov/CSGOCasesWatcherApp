package com.example.csgocaseswatcherapp.data.api

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ApiTools {

    companion object {

        private var serverApi: ServerApi? = null

        private fun getClient(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }


        fun getApiService(): ServerApi {
            if (serverApi == null) {
                serverApi = getRetrofit().create(ServerApi::class.java)
            }
            return serverApi!!
        }
    }
}
