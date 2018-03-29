package com.example.mohamed.joke.applevel.service

import com.example.mohamed.joke.applevel.AthleteConfig
import com.example.mohamed.joke.module.home.pojo.AtheleticsResponse
import retrofit2.Call
import retrofit2.http.GET

interface RestClient {
    @GET(AthleteConfig.ATHELET_FILE)
    fun getAthelitics(): Call<AtheleticsResponse>
}