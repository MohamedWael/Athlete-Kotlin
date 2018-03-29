package com.example.mohamed.joke.base.service

import retrofit2.Call
import retrofit2.Callback

open class BaseService<Response, RestClient> : Callback<Response> {

    protected var callback: Callback<Response>? = null

    fun sendAsync(call: Call<Response>, callback: Callback<Response>) {
        this.callback = callback
        call.enqueue(this)
    }

    fun createRestClient(restClient: Class<RestClient>): RestClient {
        return RetrofitBase.createRestClient(restClient)
    }

    override fun onResponse(call: Call<Response>?, response: retrofit2.Response<Response>?) {
        callback?.onResponse(call, response)
    }

    override fun onFailure(call: Call<Response>?, t: Throwable?) {
        callback?.onFailure(call, t)
    }

}