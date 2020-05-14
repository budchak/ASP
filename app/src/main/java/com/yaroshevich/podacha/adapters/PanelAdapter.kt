package com.yaroshevich.podacha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.room.entities.Panel
import kotlinx.android.synthetic.main.item_panel_info.view.*

class PanelAdapter: BaseAdapter<Panel>(), WorkHeaderHolder.Click {

    override fun click() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        0 -> WorkHeaderHolder(LayoutInflater.from(parent.context).inflate(R.layout.header_work, parent, false),this)
        else -> PanelViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_panel_info,
                parent,
                false
            )
        )
    }


    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> 0
        else -> 1
    }
}

class PanelViewHolder(view: View): RecyclerView.ViewHolder(view), BaseAdapter.Binder<Panel>{

    override fun bind(item: Panel, listener: BaseAdapter.ItemClickListener?) {
        itemView.apply {
            name.text = item.name
        }
    }

}