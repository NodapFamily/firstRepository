package com.example.nodap

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import com.example.nodap.base.BaseActivity
import com.example.nodap.databinding.ActivityMainBinding
import com.example.nodap.viewModel.MainViewModel
import com.jakewharton.rxbinding3.view.clicks
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val binding by binding(R.layout.activity_main)
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply{
            viewModel = this@MainActivity.mViewModel
            this.setVariable(BR.viewModel,mViewModel)
            this.executePendingBindings()
        }
        processClickEvent(findViewById(R.id.tv_test))
    }


    private fun processClickEvent(view : View){
        val observable =view.clicks()
        observable.debounce(500, TimeUnit.MILLISECONDS).subscribe {
            Toast.makeText(this,"Hi",Toast.LENGTH_LONG).show()
        }
    }

    override fun initViewModel(): ViewModel {
        mViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)
        return mViewModel
    }
}