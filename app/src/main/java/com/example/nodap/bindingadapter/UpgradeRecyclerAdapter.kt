package com.example.nodap.bindingadapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import java.util.*


/**
 * @author 이준혁
 * @date 2020/12/05
 *
 * 베이직 어댑터 클래스 중복클래스 제네릭으로 변경.
 *  기존에는 클릭과 된게 아이템이였는데 클릭된게 아이템이 아니여도 되도록 변경.
 * T item
 * E clickListener
 * K clickItem
 */
abstract class UpgradeRecyclerAdapter<T, E : BaseElementClickType, K, ItemBinding : ViewDataBinding>
    (var items: ArrayList<T>, var iRecyclerViewItemClick: IRecyclerViewItemClick<K, E>?)
    : RecyclerView.Adapter<BaseBindingViewHolder<ItemBinding>>() {

    /**************************************************************************************************
     *                                          상위 메소드 override 하는 부분
     * *************************************************************************************************/
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder<ItemBinding>

    override fun getItemCount(): Int {
        return items.size
    }

    abstract override fun onBindViewHolder(holder: BaseBindingViewHolder<ItemBinding>, position: Int)
}