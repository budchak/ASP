package com.yaroshevich.podacha

import android.app.Application
import com.yaroshevich.podacha.models.LoginManager

class App: Application() {

    val loginManager = LoginManager()


    override fun onCreate() {
        super.onCreate()

    }

    fun getInstance(): App{
        return this
    }


}