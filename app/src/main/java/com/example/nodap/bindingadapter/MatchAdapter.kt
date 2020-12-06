package com.example.nodap.bindingadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.nodap.R
import com.example.nodap.databinding.ItemTempBinding
import com.example.nodap.model.ResMatch

class MatchAdapter(
    items: ArrayList<ResMatch>,
    iRecyclerViewItemClick: IRecyclerViewItemClick<ResMatch, BaseElementClickType>?
) : UpgradeRecyclerAdapter<
        ResMatch,
        BaseElementClickType,
        ResMatch,
        ItemTempBinding>
    (items, iRecyclerViewItemClick) {


    override fun onBindViewHolder(holder: BaseBindingViewHolder<ItemTempBinding>, position: Int) {
        val element: ResMatch = items[position]


        holder.binding().apply {
            tvTemp.text = element.toString()
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseBindingViewHolder<ItemTempBinding> {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_temp, parent, false)


        return BaseBindingViewHolder(view)
    }

}