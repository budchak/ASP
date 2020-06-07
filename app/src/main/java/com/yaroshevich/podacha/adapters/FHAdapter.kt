package com.yaroshevich.podacha.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.adapters.factories.ViewHolderFactory


abstract class FHAdapter<T> : BaseAdapter<T>() {

    private val headerType = 0

    private val footerType = 1

    private val normalType = 2

    private var viewHolderFactory: ViewHolderFactory = createViewHolderFactory()

    var headerClickListener: ItemClickListener? = null
        set(lister){
            field = lister
            notifyDataSetChanged()
        }

    var footerClickListener: ItemClickListener? = null
        set(lister){
            field = lister
            notifyDataSetChanged()
        }

    var headerView: View? = null
    var footerView: View? = null

    var isHeaderAvailable = false
    var isFooterAvailable = false


    abstract fun createViewHolderFactory(): ViewHolderFactory


    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return when (viewType) {
            0 -> viewHolderFactory.createHeader(parent, viewType, headerClickListener)
            1 -> viewHolderFactory.createFooter(parent, viewType, footerClickListener)
            else -> viewHolderFactory.createNormal(parent, viewType, getListener())

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is HeaderViewHolder) {
            holder.bind()
            return
        }

        if (holder is FooterViewHolder) {
            holder.bind()
            return
        }


        (holder as Binder<T>).bind(items[position], getListener())


    }


    override fun getItemCount(): Int {
        var totalItemSize = items.size
        if (isHeaderAvailable) {
            totalItemSize++
        }
        if (isFooterAvailable) {
            totalItemSize++
        }

        return totalItemSize
    }

    override fun getItemViewType(position: Int): Int {

        if (position == 0 && isHeaderAvailable) {
            return headerType
        } else if (position == itemCount - 1 && isFooterAvailable) {
            return footerType
        } else return normalType
    }
}


abstract class ClickableViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var clickListener: BaseAdapter.ItemClickListener? = null

    fun addClickListener(listener: BaseAdapter.ItemClickListener?) {
        clickListener = listener
    }
}

abstract class HeaderViewHolder(view: View) : ClickableViewHolder(view) {
    abstract fun bind()
}

abstract class FooterViewHolder(view: View) : ClickableViewHolder(view) {
    abstract fun bind()
}