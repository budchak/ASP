package com.yaroshevich.podacha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.interfaces.ClickListenerID
import com.yaroshevich.podacha.room.entities.Panel
import com.yaroshevich.podacha.room.entities.Work
import kotlinx.android.synthetic.main.item_panel_info.view.*

class PanelAdapter(var clickListenerID: ClickListenerID): BaseAdapter<Panel>(), WorkHeaderHolder.Click {

    //запустить диалог добавления новой панели
    override fun click() {
        clickListenerID.click(2)
    }

    override fun getItemCount(): Int {
        return items.size + 1
    }


    fun additems(list: List<Panel>){
        items = list as MutableList<Panel>
        notifyDataSetChanged()
    }

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        0 -> WorkHeaderHolder(LayoutInflater.from(parent.context).inflate(R.layout.header_work, parent, false),this)
        else -> PanelViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_panel_info,
                parent,
                false
            )
        )
    }


    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> 0
        else -> 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(position){
            0 ->  (holder as WorkHeaderHolder).bind(Work(2,2,2,2,2,2), getListener())
            else -> (holder as PanelViewHolder).bind(items[position-1], getListener())
        }

    }
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