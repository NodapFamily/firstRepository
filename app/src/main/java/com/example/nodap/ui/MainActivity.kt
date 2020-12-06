package com.example.nodap.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import com.example.nodap.BR
import com.example.nodap.R
import com.example.nodap.base.BaseActivity
import com.example.nodap.databinding.ActivityMainBinding
import com.example.nodap.viewModel.MainViewModel
import com.jakewharton.rxbinding3.view.clicks

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val binding by binding(R.layout.activity_main)
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            viewModel = this@MainActivity.mViewModel
            lifecycleOwner = this@MainActivity
            this.setVariable(BR.viewModel, mViewModel)
            this.executePendingBindings()
        }
        processClickEvent(findViewById(R.id.tv_test))
        processClickEvent(findViewById(R.id.imageView))

        mViewModel.initSettingSummonerName(null)
        Log.e("Test", mViewModel.summonerName.value)
    }


    @SuppressLint("CheckResult")
    override fun processClickEvent(view: View) {
        val observable = view.clicks()
        observable/*.debounce(500, TimeUnit.MILLISECONDS)*/.subscribe {

            when (view.id) {
                R.id.tv_test -> {
                    val intent = Intent(this, MatchListActivity::class.java)
                    val accountId: String? = mViewModel.selectedDetail.value?.accountId
                    val name: String? = mViewModel.selectedDetail.value?.name
                    if (accountId != null && name != null) {
                        intent.putExtra("accountId", accountId)
                        intent.putExtra("name", name)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, mViewModel.summonerName.value, Toast.LENGTH_LONG)
                            .show()
                    }
                }
                R.id.imageView -> {
                    mViewModel.requestGetSummonersByName(mViewModel.summonerName.value)
                }
            }

        }
    }

    override fun initViewModel(): ViewModel {
        mViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)
        return mViewModel
    }
}