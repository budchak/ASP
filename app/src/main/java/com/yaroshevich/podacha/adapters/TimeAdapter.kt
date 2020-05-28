package com.yaroshevich.podacha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.room.entities.Time
import kotlinx.android.synthetic.main.item_time_mark.view.*

class TimeAdapter: BaseAdapter<Time>() {
    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TimeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_time_mark, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TimeViewHolder).bind(items.get(position))
    }

    fun addItems(items: List<Time>){
        val i = mutableListOf<Time>()
        i.addAll(items)
        this.items = i
        notifyDataSetChanged()
    }


    class TimeViewHolder(view: View): RecyclerView.ViewHolder(view), Binder<Time>{


        override fun bind(item: Time, listener: ItemClickListener?) {
            itemView.name.text = item.time
        }

    }
}