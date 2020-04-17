package com.yaroshevich.podacha.repositories

import com.yaroshevich.podacha.models.Session
import java.util.*

class SessionRepository : repository<Session> {

    var session: MutableList<Session> = mutableListOf()

    init {
        var i = 0

        var calendar = Calendar.getInstance()
        var date = calendar.time
            while (i++ < 100) {
                date = calendar.time
                session.add(Session(i, "name" + i, date))

                calendar.add(Calendar.DAY_OF_MONTH, 1)
            }


    }

    override fun getAll(): List<Session> {
        return session
    }

    override fun create(item: Session) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(item: Session) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(item: Session) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}