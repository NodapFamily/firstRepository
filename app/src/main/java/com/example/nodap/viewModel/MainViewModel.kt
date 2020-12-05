package com.example.nodap.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nodap.model.ResSummonerData
import com.example.nodap.network.HttpClient
import com.example.nodap.network.IApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel() : ViewModel() {


    val summonerName: MutableLiveData<String> = MutableLiveData()
    val selectedDetail: MutableLiveData<String> = MutableLiveData()
//    val selectedSummoner : Summoner = TODO()
//    val characterList : LiveData<Character>

    fun initSettingSummonerName(name: String?) {
        summonerName.value = name ?: "핑크왕자혁이"
    }

    fun requestGetSummonersByName(name: String?) {

        val api = HttpClient.retrofit.create(IApi::class.java)

        val call: Call<ResSummonerData> = api.requestSummonerByName(name)
        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue(object : Callback<ResSummonerData> {
            // 통신성공 후 텍스트뷰에 결과값 출력
            override fun onResponse(call: Call<ResSummonerData>, response: Response<ResSummonerData>) {
                selectedDetail.value = response.body().toString()
            }

            // 통신실패
            override fun onFailure(call: Call<ResSummonerData>, t: Throwable) {
                selectedDetail.value = t.toString()

            }
        })


    }

}