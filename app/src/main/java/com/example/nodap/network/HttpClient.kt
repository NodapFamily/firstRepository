package com.example.nodap.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object HttpClient {
    val retrofit: Retrofit

    init {
        val builder = Retrofit.Builder()
        builder.baseUrl("https://reqres.in/")
        builder.addConverterFactory(GsonConverterFactory.create()) // 받아오는 Json 구조의 데이터를 객체 형태로 변환
        retrofit = builder.build()
    }


}