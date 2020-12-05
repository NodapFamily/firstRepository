package com.example.nodap.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BaseBindingUtil {
    @BindingAdapter(value = ["app:calendarSettingItems", "app:calendarSettingClick"])
    fun bindCalendarSetting(rv: RecyclerView, items: ArrayList<String>?, iRecyclerViewItemClick:  IRecyclerViewItemClick<String, BaseElementClickType>?) {
        if (items == null) return
        var adapter = rv.adapter as TempAdapter?
        if (adapter == null) {
            adapter = TempAdapter(arrayListOf(), iRecyclerViewItemClick)
            rv.layoutManager = LinearLayoutManager(rv.context)
            rv.setHasFixedSize(true)
            rv.adapter = adapter
            adapter.setClick(iRecyclerViewItemClick)
            adapter.notifyDataSetChanged()
        } else {
            adapter.setClick(iRecyclerViewItemClick)
        }
    }
}