package com.yaroshevich.podacha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.models.PodachaItem

class WorkAdapter : BaseAdapter<PodachaItem>() {


    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        WorkViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_work, parent, false))
    

    class WorkViewHolder(view: View) : RecyclerView.ViewHolder(view), Binder<PodachaItem> {


        override fun bind(item: PodachaItem, listener: ItemClickListener?) {

        }

    }

}