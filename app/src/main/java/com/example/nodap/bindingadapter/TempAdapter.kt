package com.example.nodap.bindingadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.nodap.R

class TempAdapter(
    items: ArrayList<CalendarItem>,
    iRecyclerViewItemClick: IRecyclerViewItemClick<String, BaseElementClickType>?
) : UpgradeRecyclerAdapter<
        TempAdapter.CalendarItem,
        BaseElementClickType,
        String,
        ViewDataBinding>
    (items, iRecyclerViewItemClick) {


    override fun onBindViewHolder(holder: BaseBindingViewHolder<ViewDataBinding>, position: Int) {
        val element: CalendarItem = items[position]

//        when (holder.binding()) {
//            is ItemParentAccountBinding -> {
//                (holder.binding() as ItemParentAccountBinding).tvAccountName.text = element.accountName
//            }
//            is ItemChildCalendarBinding -> {
//                val calendar = element.calendar ?: return
//
//
//                @ColorInt
//                val color = Color.parseColor(hexStringtoColor(calendar.color))
//
//                val unwrappedDrawable: Drawable? = AppCompatResources.getDrawable(TWMan.baseContext, R.drawable.dr_calendar_round_color)
//                val wrappedDrawable: Drawable? = unwrappedDrawable?.let { DrawableCompat.wrap(it) }
//
//                (holder.binding() as ItemChildCalendarBinding).ivCheckColor.setImageDrawable(
//                    if (wrappedDrawable != null) {
//                        DrawableCompat.setTint(wrappedDrawable, color)
//                        wrappedDrawable
//                    } else {
//                        wrappedDrawable
//                    }
//                )
//                (holder.binding() as ItemChildCalendarBinding).ivCheckCover.visibility=(if (calendar.visible > 0) {
//                    View.GONE
//                } else {
//                    View.VISIBLE
//                })
//
//
//                (holder.binding() as ItemChildCalendarBinding).clItemCalendar.setOnClickListener {
//                    iRecyclerViewItemClick?.onItemClick(calendar, BaseElementClickType.ELEMENT)
//                }
//                (holder.binding() as ItemChildCalendarBinding).tvCalendarName.text = calendar.name
//
//            }
//            else -> {
//            }
//        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }

    fun getClick(): IRecyclerViewItemClick<String, BaseElementClickType>? {
        return super.iRecyclerViewItemClick
    }

    fun setClick(iRecyclerViewItemClick: IRecyclerViewItemClick<String, BaseElementClickType>?) {
        super.iRecyclerViewItemClick = iRecyclerViewItemClick
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseBindingViewHolder<ViewDataBinding> {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_temp, parent, false)


        return BaseBindingViewHolder(view)
    }


    class CalendarItem(
        var type: Int,
        var accountName: String?
    ) {
    }

    companion object {
        const val HEADER = 0
        const val CHILD = 1
    }

}