package com.example.nodap

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nodap.base.BaseActivity
import com.example.nodap.databinding.ActivityMainBinding
import com.example.nodap.viewModel.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding3.view.clicks

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
    }


    private fun processClickEvent(view : View){
        val observable =view.clicks()
        observable.subscribe {
            Toast.makeText(this,"Hi",Toast.LENGTH_LONG).show()
        }.dispose()
    }

    override fun initViewModel(): ViewModel {
        mViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)
        return mViewModel
    }
}