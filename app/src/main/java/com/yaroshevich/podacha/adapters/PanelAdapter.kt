package com.yaroshevich.podacha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.adapters.factories.ViewHolderFactory
import com.yaroshevich.podacha.interfaces.ClickListenerID
import com.yaroshevich.podacha.room.entities.Panel
import com.yaroshevich.podacha.room.entities.Work
import kotlinx.android.synthetic.main.item_panel_info.view.*

class PanelAdapter(var clickListenerID: ClickListenerID): FHAdapter<Panel>(){


    override fun createViewHolderFactory(): ViewHolderFactory = PanelViewHolderFactory()





}

class PanelViewHolder(view: View): RecyclerView.ViewHolder(view), BaseAdapter.Binder<Panel>{

    override fun bind(item: Panel, listener: BaseAdapter.ItemClickListener?) {
        itemView.apply {
            name.text = item.name
        }
        itemView.setOnClickListener {
            listener?.onItemClick(item.id)
        }
    }

}

class PanelHeader(view: View): HeaderViewHolder(view)

class PanelFooter(view: View): FooterViewHolder(view)

class PanelViewHolderFactory: ViewHolderFactory() {

    override fun createHeader(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        return PanelHeader(LayoutInflater.from(parent.context).inflate(R.layout.header_work, parent,false))
    }

    override fun createFooter(parent: ViewGroup, viewType: Int): FooterViewHolder {
        return PanelFooter(LayoutInflater.from(parent.context).inflate(R.layout.item_panel_info, parent,false))
    }

    override fun createNormal(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return PanelViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.header_work, parent,false))
    }

}