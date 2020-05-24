package com.yaroshevich.podacha.repositories

import com.yaroshevich.podacha.models.PodachaItem
import java.util.*

class PodachaRepository: repository<PodachaItem> {


    var items: MutableList<PodachaItem> = mutableListOf()

    init {
        var i = 0

        var calendar = Calendar.getInstance()
        var date = calendar.time
        while (i++ < 10) {
            date = calendar.time
            items.add(PodachaItem(i, "name" + i, i, i))

            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }


    }


    override fun getAll(): List<PodachaItem> {
       return items
    }

    override fun create(item: PodachaItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(item: PodachaItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(item: PodachaItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}