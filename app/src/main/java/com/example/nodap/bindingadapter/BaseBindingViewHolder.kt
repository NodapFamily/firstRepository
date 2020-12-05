package com.example.nodap.bindingadapter


import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author 이준혁
 * @date 2020/12/05
 *  base 어댑터에 해당하는 기본 base 뷰홀더.
 */
class BaseBindingViewHolder<T : ViewDataBinding>(view: View) : RecyclerView.ViewHolder(view) {
    private val binding: T = DataBindingUtil.bind(view)!!

    fun binding(): T {
        return binding
    }
}