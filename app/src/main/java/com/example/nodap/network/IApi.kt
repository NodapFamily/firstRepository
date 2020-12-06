package com.example.nodap.network

import com.example.nodap.model.ResMatchLists
import com.example.nodap.model.ResSummonerData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApi {

//    https://kr.api.riotgames.com/
//    https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/%ED%95%91%ED%81%AC%EC%99%95%EC%9E%90%ED%98%81%EC%9D%B4
    @GET("lol/summoner/v4/summoners/by-name/{summonerName}")
    fun requestSummonerByName( @Path(value = "summonerName", encoded = true) summonerName: String?): Call<ResSummonerData>

    //    https://kr.api.riotgames.com/
//    https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/%ED%95%91%ED%81%AC%EC%99%95%EC%9E%90%ED%98%81%EC%9D%B4
    @GET("lol/match/v4/matchlists/by-account/{encryptedAccountId}")
    fun requestMatchListsByAccount(@Path(value = "encryptedAccountId", encoded = true) accountId: String?): Call<ResMatchLists>

//    base_url + "api/login" 으로 POST 통신
//    @POST("api/login")
//    fun requestPostLogin(@Body reqLoginData: ReqLoginData?): Call<ResLoginData?>? // @Body : request 파라미터
//
//
    // base_url + "api/users" 으로 GET 통신
    @GET("api/users")
    fun requestGetUsersDetail(
        @Query(
            value = "page",
            encoded = true
        ) page: String?
    ): Call<ResSummonerData?>? // @Query : url에 쿼리 파라미터 추가, encoded - true


}

