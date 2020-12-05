package com.example.nodap.bindingadapter

interface IRecyclerViewItemClick<E , T : BaseElementClickType> {

    fun onItemClick(item: E, type: T)
    fun onItemLongClick(item: E, type: T): Boolean
}
