package com.example.mohamed.joke.module.home.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Athlete : Serializable{

    @SerializedName("brief")
    var brief: String? = null
    @SerializedName("image")
    var image: String? = null
    @SerializedName("name")
    var name: String? = null

}
