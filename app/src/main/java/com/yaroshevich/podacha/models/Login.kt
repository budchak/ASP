package com.yaroshevich.podacha.models

class Login(var login: String, var password: String) {


    fun equals(other: Login): Boolean {
        if (login.equals(other.login) && password.equals(other.password)) return true

        return false
    }
}