package com.example.nodap.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nodap.model.ResMatch

class BaseBindingUtil {

    @BindingAdapter(value = ["app:matchs", "app:matchsClick"])
    fun bindMatchItem(rv: RecyclerView, items: ArrayList<ResMatch>?, iRecyclerViewItemClick:  IRecyclerViewItemClick<ResMatch, BaseElementClickType>?) {
        if (items == null) return
        var adapter = rv.adapter as MatchAdapter?
        if (adapter == null) {
            adapter = MatchAdapter(items, iRecyclerViewItemClick)
            rv.layoutManager = LinearLayoutManager(rv.context)
            rv.setHasFixedSize(true)
            rv.adapter = adapter
        }else{
            adapter.items.clear()
            adapter.items.addAll(items)
        }
        adapter.notifyDataSetChanged()
    }
}