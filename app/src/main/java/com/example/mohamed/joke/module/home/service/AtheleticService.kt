package com.example.mohamed.joke.module.home.service

import com.example.mohamed.joke.applevel.service.AppService
import com.example.mohamed.joke.applevel.service.ResponseCallBack
import com.example.mohamed.joke.module.home.pojo.AtheleticsResponse

class AtheleticService : AppService<AtheleticsResponse>() {

    fun getAtheletics(responseCallBack: ResponseCallBack<AtheleticsResponse>) {
        execute(getRestClient().getAthelitics(), responseCallBack)
    }
}