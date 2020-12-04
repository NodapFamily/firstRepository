package com.example.nodap.network

import com.example.nodap.model.ReqLoginData
import com.example.nodap.model.ResLoginData
import com.example.nodap.model.ResUsersData
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface ApiInterface {


    // base_url + "api/login" 으로 POST 통신
    @POST("api/login")
    fun requestPostLogin(@Body reqLoginData: ReqLoginData?): Call<ResLoginData?>? // @Body : request 파라미터


    // base_url + "api/users" 으로 GET 통신
    @GET("api/users")
    fun requestGetUsersDetail(
        @Query(
            value = "page",
            encoded = true
        ) page: String?
    ): Call<ResUsersData?>? // @Query : url에 쿼리 파라미터 추가, encoded - true


}