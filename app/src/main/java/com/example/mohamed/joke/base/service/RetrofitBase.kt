package com.example.mohamed.joke.base.service

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBase {
    var retrofit: Retrofit? = null

    fun init(baseUrl: String, converterFactory: Converter.Factory = GsonConverterFactory.create(), okHttpClient: OkHttpClient = OkHttpClient()) {
        retrofit = Retrofit.Builder().
                baseUrl(baseUrl).
                client(okHttpClient).
                addConverterFactory(converterFactory).
                build()
    }

    public fun <T> createRestClient(restClient: Class<T>): T {
        isRetrofitInitialized()
        return retrofit!!.create(restClient)
    }

    public fun isRetrofitInitialized() {
        if (retrofit == null) {
            throw NullPointerException("you have to call init() method first")
        }
    }
}