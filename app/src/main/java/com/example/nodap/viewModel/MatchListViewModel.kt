package com.example.nodap.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nodap.model.ResMatch
import com.example.nodap.model.ResMatchLists
import com.example.nodap.network.HttpClient
import com.example.nodap.network.IApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MatchListViewModel() : ViewModel() {


    val summonerName: MutableLiveData<String> = MutableLiveData()
    val matchs: MutableLiveData<List<ResMatch>> = MutableLiveData()

    fun initSettingSummonerName(name: String?) {
        summonerName.value = name ?: "핑크왕자혁이"
    }

    fun requestMatchListsByAccount(accountId: String?) {

        val api = HttpClient.retrofit.create(IApi::class.java)

        val call: Call<ResMatchLists> = api.requestMatchListsByAccount(accountId)
        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue(object : Callback<ResMatchLists> {
            // 통신성공 후 텍스트뷰에 결과값 출력
            override fun onResponse(call: Call<ResMatchLists>, response: Response<ResMatchLists>) {
                matchs.value = response.body()?.matches
            }

            // 통신실패
            override fun onFailure(call: Call<ResMatchLists>, t: Throwable) {
                matchs.value = null

            }
        })


    }

}