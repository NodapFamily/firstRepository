package com.example.nodap.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

public abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : AppCompatActivity() {
    private lateinit var mViewDataBinding: T
    protected lateinit var mViewModel: V


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    protected fun binding(@LayoutRes resId: Int): Lazy<T> =
        lazy {
            DataBindingUtil.setContentView<T>(this, resId)
        }

    abstract fun initViewModel(): ViewModel
}