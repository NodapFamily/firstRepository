package com.example.nodap.network

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object HttpClient {
    val retrofit: Retrofit

    //https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/j_H6hyjCYYgTx8yIv93J7F80tocup894pc_UrbOtnB0
    //https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/%ED%95%91%ED%81%AC%EC%99%95%EC%9E%90%ED%98%81%EC%9D%B4

    init {

        val interceptor = HttpLoggingInterceptor()
        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.HEADERS }

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor { chain ->
            val request: Request =
                chain.request().newBuilder().addHeader(
                    "X-Riot-Token",
                    "RGAPI-d7048923-3875-4262-8d0c-8f25404d3c61"
                ).build()
            chain.proceed(request)
        }

        retrofit =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://kr.api.riotgames.com/")
                .client(httpClient.build()).build()

    }


}