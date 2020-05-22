package com.yaroshevich.podacha.repositories

import com.yaroshevich.podacha.App
import com.yaroshevich.podacha.room.entities.Panel

class PanelRepository {

    val panelDao = App.getInstance().database?.panelDao()


    fun getAll()= panelDao?.getAll()

    fun getById(id : Int) = panelDao?.getById(id)

    fun create(item: Panel) {
        panelDao?.insert(item)
    }

    fun update(item: Panel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun delete(item: Panel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}