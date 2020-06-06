package com.yaroshevich.podacha.repositories

import com.yaroshevich.podacha.App
import com.yaroshevich.podacha.room.entities.Session
import com.yaroshevich.podacha.room.entities.Work

import java.util.*

class SessionRepository : repository<Session> {

    var session: MutableList<Session> = mutableListOf()
    val sessionDao = App.getInstance().database?.sessionDao()
    val workDao = App.getInstance().database?.workDao()
    val timeDao = App.getInstance().database?.timeDao()

    override fun getAll(): MutableList<Session> {
        return sessionDao!!.getAll() as MutableList<Session>
    }

    fun getMaxId() =
        App.getInstance().database?.sessionDao()?.getMaxId()


    override fun create(item: Session) {
        sessionDao?.insert(item)
    }

    override fun update(item: Session) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun delete(item: Session) {

        val list = workDao?.getBySessionId(item.id)
        if (list != null){
            for ( item: Work in list){
                var time = timeDao?.getById(item.id)
                if (time != null){
                    timeDao?.delete(time)
                }

            }
            workDao?.delete(list)
        }
        sessionDao?.delete(item)

    }
}