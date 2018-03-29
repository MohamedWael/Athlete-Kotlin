package com.example.mohamed.joke.applevel.service

import com.example.mohamed.joke.base.service.BaseService
import retrofit2.Call

open class AppService<Response> : BaseService<Response, RestClient>() {

    private var responseCallBack: ResponseCallBack<Response>? = null

    fun getRestClient(): RestClient {
        return createRestClient(RestClient::class.java)
    }

    fun execute(call: Call<Response>, responseCallBack: ResponseCallBack<Response>) {
        this.responseCallBack = responseCallBack
        sendAsync(call, this)
    }

    override fun onResponse(call: Call<Response>?, response: retrofit2.Response<Response>?) {

        //some business error can be handled here as well
        responseCallBack?.onSuccess(response?.body(), response)

    }

    override fun onFailure(call: Call<Response>?, t: Throwable?) {
        responseCallBack?.onFailure(AtheleticErrorHandler(t), call)
    }
}