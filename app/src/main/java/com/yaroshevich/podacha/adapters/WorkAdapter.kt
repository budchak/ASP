package com.yaroshevich.podacha.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.repositories.PanelRepository
import com.yaroshevich.podacha.repositories.TimeRepository
import com.yaroshevich.podacha.room.entities.Time
import com.yaroshevich.podacha.room.entities.Work
import kotlinx.android.synthetic.main.header_work.view.*
import kotlinx.android.synthetic.main.item_work.view.*

class WorkAdapter(var context: Context) : BaseAdapter<Work>(), WorkHeaderHolder.Click {

    var listenerHeader: WorkHeaderHolder.Click? = null

    var isHeaderVisible: Boolean = true

    fun viewHeader(visible: Boolean) {
        this.isHeaderVisible = visible
    }

    override fun click() {
        listenerHeader?.click()

    }

    fun setListener(listener: WorkHeaderHolder.Click) {
        listenerHeader = listener
    }

    fun setData(list: List<Work>) {
        this.items = list as MutableList<Work>
        notifyDataSetChanged()
    }


    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            0 -> WorkHeaderHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.header_work, parent, false),
                this
            )
            else -> WorkViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_work, parent, false)
            )
        }


    override fun getItemViewType(position: Int): Int {

        if (isHeaderVisible) {
            return when (position) {
                0 -> 0
                else -> 1
            }
        } else return 1

    }


    override fun getItemCount() =
        when (isHeaderVisible) {
            true -> items.size + 1
            false -> items.size
        }


    fun add(item: Work) {
        items.add(item)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isHeaderVisible) {
            when (position) {
                0 -> (holder as WorkHeaderHolder).bind(
                    Work(
                        panelId = 2,
                        color = 2,
                        number = 2,
                        sessionID = 0
                    ), getListener()
                )
                else -> (holder as WorkViewHolder).bind(items[position - 1], getListener())
            }
        } else {
            (holder as WorkViewHolder).bind(items[position], getListener())
        }


    }

    class WorkViewHolder(view: View) : RecyclerView.ViewHolder(view), Binder<Work> {


        override fun bind(item: Work, listener: ItemClickListener?) {
            val timeAdapter = TimeAdapter()
            var repo = TimeRepository()

            var items = repo.getAll()
            itemView.apply {
                val panelRepo = PanelRepository()
                if (item.color == 2) {
                    cardView4.setBackgroundColor(Color.parseColor("#AAAAAA"))
                }

                var isRecVisible = false
                container.setOnClickListener {
                    infoRecyclerView.visibility = when (isRecVisible) {
                        false -> {
                            isRecVisible = true
                            View.VISIBLE
                        }
                        true -> {
                            isRecVisible = false
                            View.GONE
                        }
                    }
                }
                val list = mutableListOf<Time>()
                plus.setOnClickListener {
                    list.add(Time(0,"15:05",2,2))
                    Toast.makeText(context, "plus", Toast.LENGTH_SHORT).show()
                    
                    timeAdapter.items = list
                    timeAdapter.notifyDataSetChanged()
                }
                infoRecyclerView.apply {
                    layoutManager = LinearLayoutManager(itemView.context)
                    this.adapter = timeAdapter


                }


                name.setText(panelRepo?.getById(item.panelId)!!.name)
            }
        }

    }

}

class WorkHeaderHolder(view: View, var listener: Click) : RecyclerView.ViewHolder(view),
    BaseAdapter.Binder<Work> {

    override fun bind(item: Work, listener: BaseAdapter.ItemClickListener?) {

        itemView.apply {


            addButton.setOnClickListener { v ->
                this@WorkHeaderHolder.listener.click()
            }

        }
    }

    interface Click {
        fun click()
    }

}