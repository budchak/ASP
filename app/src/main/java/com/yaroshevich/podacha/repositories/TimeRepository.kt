package com.yaroshevich.podacha.repositories

import com.yaroshevich.podacha.App
import com.yaroshevich.podacha.room.entities.Time

class TimeRepository {

    val timeDao = App.getInstance().database?.timeDao()

    fun getAll() = timeDao?.getAll()

    fun create(item: Time) {
       timeDao?.insert(item)
    }

    fun update(item: Time) {
        TODO("Not yet implemented")
    }

    fun delete(item: Time) {
        TODO("Not yet implemented")
    }
}