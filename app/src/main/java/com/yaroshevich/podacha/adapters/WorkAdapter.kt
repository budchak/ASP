package com.yaroshevich.podacha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.models.PodachaItem
import kotlinx.android.synthetic.main.header_work.view.*

class WorkAdapter : BaseAdapter<PodachaItem>(), WorkHeaderHolder.Click {
    override fun click(item: PodachaItem) {
        add(item)
    }


    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        0 -> WorkHeaderHolder(LayoutInflater.from(parent.context).inflate(R.layout.header_work, parent, false),this)
        else -> WorkViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_work, parent, false))
    }


    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> 0
        else -> 1
    }


    override fun getItemCount(): Int {
        return items.size + 1
    }

    fun add(item: PodachaItem) {
        items.add(item)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(position){
            0 -> (holder as WorkHeaderHolder).bind(PodachaItem(0, "sfd", 0,2), listener)
            else -> (holder as WorkViewHolder).bind(items[position-1], listener)
        }

    }

    class WorkViewHolder(view: View) : RecyclerView.ViewHolder(view), Binder<PodachaItem> {


        override fun bind(item: PodachaItem, listener: ItemClickListener?) {

        }

    }

}

class WorkHeaderHolder(view: View, var listener: Click) : RecyclerView.ViewHolder(view),
    BaseAdapter.Binder<PodachaItem> {
    override fun bind(item: PodachaItem, listener: BaseAdapter.ItemClickListener?) {

        itemView.addButton.setOnClickListener { v ->
            this.listener.click(PodachaItem(2, "Adff", 2, 2))
        }

    }

    interface Click {
        fun click(item: PodachaItem)
    }

}