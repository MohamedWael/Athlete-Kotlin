package com.example.mohamed.joke.applevel.application

import android.app.Application
import com.example.mohamed.joke.applevel.AthleteConfig
import com.example.mohamed.joke.base.service.RetrofitBase

class AthleteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitBase.init(AthleteConfig.ENDPOINT)
    }
}