package com.yaroshevich.podacha.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.yaroshevich.podacha.App
import com.yaroshevich.podacha.room.entities.Work

class WorkRepository {

    val workDao = App.getInstance().database?.workDao()



    fun getAll()= workDao?.getAll()


     fun create(item: Work) {
        workDao?.insert(item)
    }

     fun update(item: Work) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun delete(item: Work) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}