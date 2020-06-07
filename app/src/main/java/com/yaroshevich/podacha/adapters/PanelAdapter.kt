package com.yaroshevich.podacha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.adapters.factories.ViewHolderFactory
import com.yaroshevich.podacha.interfaces.ClickListenerID
import com.yaroshevich.podacha.room.entities.Panel
import kotlinx.android.synthetic.main.header_work.view.*
import kotlinx.android.synthetic.main.item_panel_info.view.*

class PanelAdapter(var clickListenerID: ClickListenerID) : FHAdapter<Panel>() {


    override fun createViewHolderFactory(): ViewHolderFactory = PanelViewHolderFactory()


}

class PanelViewHolder(view: View) : RecyclerView.ViewHolder(view), BaseAdapter.Binder<Panel> {

    var listener: BaseAdapter.ItemClickListener? = null

    override fun bind(item: Panel, listenerNPL: BaseAdapter.ItemClickListener?) {

        itemView.apply {
            name.text = item.name
        }

        itemView.setOnClickListener {
            listener?.onItemClick(item.id)
        }
    }

}

class PanelHeader(view: View) : HeaderViewHolder(view){
    override fun bind() {
        itemView.addButton.setOnClickListener {
            clickListener?.onItemClick(5555)
        }
    }

}

class PanelFooter(view: View) : FooterViewHolder(view){
    override fun bind() {
        itemView.addButton.setOnClickListener {
            clickListener?.onItemClick(6666)
        }
    }

}

class PanelViewHolderFactory : ViewHolderFactory() {

    override fun createHeader(
        parent: ViewGroup,
        viewType: Int,
        listener: BaseAdapter.ItemClickListener?
    ): HeaderViewHolder {

        val holder = PanelHeader(
            LayoutInflater.from(parent.context).inflate(R.layout.header_work, parent, false)
        )

        holder.clickListener = listener

        return holder
    }

    override fun createFooter(
        parent: ViewGroup,
        viewType: Int,
        listener: BaseAdapter.ItemClickListener?
    ): FooterViewHolder {
        val holder = PanelFooter(
            LayoutInflater.from(parent.context).inflate(R.layout.header_work, parent, false)
        )
        holder.clickListener = listener
        return holder

    }

    override fun createNormal(parent: ViewGroup, viewType: Int, listener: BaseAdapter.ItemClickListener?): RecyclerView.ViewHolder {

        val holder = PanelViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_panel_info, parent, false)
        )
        holder.listener = listener
        return holder

    }

}