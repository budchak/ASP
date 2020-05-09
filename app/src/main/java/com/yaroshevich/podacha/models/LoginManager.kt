package com.yaroshevich.podacha.models

class LoginManager {

    val list = mutableListOf<Login>()

    init {
        list.add(Login("Admin", "admin"))
    }

    fun isFind(login: Login): Boolean{
        for (item : Login in list){
            if (item.equals(login))
                return true
        }
        return false
    }
}