package com.yaroshevich.podacha.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = mutableListOf<T>()

    private var listener: ItemClickListener? = null


    fun setListener(listener: ItemClickListener?) {
        this.listener = listener
    }

    fun getListener() = listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        getViewHolder(parent, viewType)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).bind(items[position], listener)
    }

    abstract fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    interface Binder<T> {

        fun bind(item: T, listener: ItemClickListener? = null)

    }

    interface ItemClickListener {

        fun onItemClick(id: Int)

    }
}