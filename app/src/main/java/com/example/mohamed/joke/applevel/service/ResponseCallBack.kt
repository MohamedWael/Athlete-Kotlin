package com.example.mohamed.joke.applevel.service

import com.example.mohamed.joke.base.service.ErrorHandler
import retrofit2.Call

interface ResponseCallBack<Response> {
    fun onSuccess(r: Response?, response: retrofit2.Response<Response>?)
    fun onFailure(errorHandler: ErrorHandler?, call: Call<Response>?)
}