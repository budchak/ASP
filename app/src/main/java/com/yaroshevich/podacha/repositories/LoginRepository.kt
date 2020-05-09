package com.yaroshevich.podacha.repositories

import com.yaroshevich.podacha.models.User

class LoginRepository : repository<User> {


    fun getUserfromLogin(login: String ,password: String ){

    }

    override fun getAll(): List<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(item: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(item: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(item: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}