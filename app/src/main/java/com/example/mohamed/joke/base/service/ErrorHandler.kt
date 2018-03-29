package com.example.mohamed.joke.base.service

interface ErrorHandler {

    fun getStringRes(): Int
    fun getString(): String = ""
}