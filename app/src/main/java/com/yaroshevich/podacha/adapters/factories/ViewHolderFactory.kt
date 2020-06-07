package com.yaroshevich.podacha.adapters.factories

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.adapters.BaseAdapter
import com.yaroshevich.podacha.adapters.FooterViewHolder
import com.yaroshevich.podacha.adapters.HeaderViewHolder


abstract class ViewHolderFactory {

    abstract fun createHeader(parent: ViewGroup, viewType: Int, listener: BaseAdapter.ItemClickListener?): HeaderViewHolder
    abstract fun createFooter(parent: ViewGroup, viewType: Int,listener: BaseAdapter.ItemClickListener?): FooterViewHolder
    abstract fun createNormal(parent: ViewGroup, viewType: Int, listener: BaseAdapter.ItemClickListener?): RecyclerView.ViewHolder
}