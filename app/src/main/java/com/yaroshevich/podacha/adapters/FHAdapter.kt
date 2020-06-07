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

    var headerView: View? = null
    var footerView: View? = null

    var isHeaderAvailable = false
    var isFooterAvailable = false

    abstract fun createViewHolderFactory(): ViewHolderFactory


    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return when (viewType) {
            0 -> viewHolderFactory.createHeader()
            1 -> viewHolderFactory.createFooter()
            else -> viewHolderFactory.createNormal()

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is HeaderViewHolder) {
            holder.addClickListener(getListener())
            return
        }

        if (holder is FooterViewHolder) {
            holder.addClickListener(getListener())
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

abstract class HeaderViewHolder(view: View) : ClickableViewHolder(view)

abstract class FooterViewHolder(view: View) : ClickableViewHolder(view)