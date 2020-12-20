package com.example.nodap.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nodap.BR
import com.example.nodap.R
import com.example.nodap.base.BaseActivity
import com.example.nodap.bindingadapter.MatchAdapter
import com.example.nodap.databinding.ActivityMatchListBinding
import com.example.nodap.model.ResMatch
import com.example.nodap.viewModel.MatchListViewModel
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_match_list.*

class MatchListActivity : BaseActivity<ActivityMatchListBinding, MatchListViewModel>() {

    private val binding by binding(R.layout.activity_match_list)
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            viewModel = this@MatchListActivity.mViewModel
            lifecycleOwner = this@MatchListActivity
            this.setVariable(BR.viewModel, mViewModel)
            this.executePendingBindings()
        }
        processClickEvent(findViewById(R.id.tv_name))
        binding.rvMatch.layoutManager = LinearLayoutManager(this)

        val dataObserver: Observer<List<ResMatch>> =
            Observer { matchs ->
                if (rv_match.adapter == null) {
                    rv_match.adapter = MatchAdapter(matchs as ArrayList<ResMatch>, null)
                } else {
                    val adapter = rv_match.adapter as MatchAdapter
                    adapter.apply {
                        adapter.items.addAll(items)
                        items.clear()
                    }
                }
                (rv_match.adapter as MatchAdapter).notifyDataSetChanged()
            }

        mViewModel.matchs.observe(this, dataObserver)
        checkIntent(intent)

    }

    private fun checkIntent(intent: Intent?) {
        if (intent != null) {
            val accountId = intent.getStringExtra("accountId")
            val summonerName = intent.getStringExtra("name")
            mViewModel.initSettingSummonerName(summonerName)
            mViewModel.requestMatchListsByAccount(accountId)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        checkIntent(intent)
    }

    override fun initViewModel(): ViewModel {
        mViewModel =
            ViewModelProvider(this).get(MatchListViewModel::class.java)
        return mViewModel
    }


    @SuppressLint("CheckResult")
    override fun processClickEvent(view: View) {
        val observable = view.clicks()
        observable/*.debounce(500, TimeUnit.MILLISECONDS)*/.subscribe {

            when (view.id) {
                R.id.tv_name -> {
                    mViewModel.requestMatchListsByAccount("j_H6hyjCYYgTx8yIv93J7F80tocup894pc_UrbOtnB0")
                }
            }

        }
    }
}