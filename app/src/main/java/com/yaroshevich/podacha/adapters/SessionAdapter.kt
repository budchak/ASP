package com.yaroshevich.podacha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R

import com.yaroshevich.podacha.models.Session
import kotlinx.android.synthetic.main.item_session.view.*
import java.util.*




class SessionAdapter : BaseAdapter<Session>() {
    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SessionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_session, parent, false))
    }


    class SessionViewHolder(view: View) : RecyclerView.ViewHolder(view), Binder<Session> {


        override fun bind(item: Session, listener: ItemClickListener?) {
            itemView.apply {
                cardView.setOnClickListener { v ->
                    if (listener != null) listener.onItemClick(item.id)
                }

                val calendar = Calendar.getInstance()
                calendar.setTime(item.date)

                date.text = calendar.get(Calendar.DAY_OF_MONTH).toString()
                day.text =  switchDay(calendar.get(Calendar.DAY_OF_WEEK))
                name.text = item.name
            }


        }


        fun switchDay(item: Int)=

            when(item){

                1 -> "ВС"
                2 -> "ПН"
                3 -> "ВТ"
                4 -> "СР"
                5 -> "ЧТ"
                6 -> "ПТ"
                7 -> "СБ"


                else ->  "[p"
            }

    }
}