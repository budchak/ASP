package com.yaroshevich.podacha.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.repositories.SessionRepository
import com.yaroshevich.podacha.room.entities.Session
import kotlinx.android.synthetic.main.item_session.view.*
import java.text.SimpleDateFormat
import java.util.*


class SessionAdapter : BaseAdapter<Session>() {



    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SessionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_session, parent, false)
        )
    }



    class SessionViewHolder(view: View) : RecyclerView.ViewHolder(view), Binder<Session> {


        override fun bind(item: Session, listener: ItemClickListener?) {
            itemView.apply {



                name.text= item.name

                container.setOnClickListener {
                   listener?.onItemClick(item.id)
                }

                delete.setOnClickListener {
                    SessionRepository().delete(item)
                    listener?.onItemClick(555555)
                }
                update.setOnClickListener {

                    listener?.onItemClick(666666)
                }

            }


        }


        fun switchDay(item: Int) =

            when (item) {

                1 -> "ВС"
                2 -> "ПН"
                3 -> "ВТ"
                4 -> "СР"
                5 -> "ЧТ"
                6 -> "ПТ"
                7 -> "СБ"


                else -> "[p"
            }

    }
}