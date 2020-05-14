package com.yaroshevich.podacha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.models.PodachaItem
import com.yaroshevich.podacha.room.entities.Work
import kotlinx.android.synthetic.main.header_work.view.*

class WorkAdapter : BaseAdapter<Work>(), WorkHeaderHolder.Click {

    var listenerHeader: WorkHeaderHolder.Click? = null

    override fun click() {
        listenerHeader?.click()

    }

    fun setListener(listener: WorkHeaderHolder.Click){
        listenerHeader = listener
    }

    fun setData(list: List<Work> ){
        this.items = list as MutableList<Work>
        notifyDataSetChanged()
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

    fun add(item: Work) {
        items.add(item)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(position){
            0 ->  (holder as WorkHeaderHolder).bind(Work(panelId = 2, color = 2, number = 2), listener)
            else -> (holder as WorkViewHolder).bind(items[position-1], listener)
        }

    }

    class WorkViewHolder(view: View) : RecyclerView.ViewHolder(view), Binder<Work> {


        override fun bind(item: Work, listener: ItemClickListener?) {

        }

    }

}

class WorkHeaderHolder(view: View, var listener: Click) : RecyclerView.ViewHolder(view),
    BaseAdapter.Binder<Work> {

    override fun bind(item: Work, listener: BaseAdapter.ItemClickListener?) {

        itemView.addButton.setOnClickListener { v ->
            this.listener.click()
        }

    }

    interface Click {
        fun click()
    }

}