package com.yaroshevich.podacha

import android.app.Application
import androidx.room.Room
import com.yaroshevich.podacha.models.LoginManager
import com.yaroshevich.podacha.room.AppDatabase

class App : Application() {

    val loginManager = LoginManager()

    var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database").allowMainThreadQueries()
                .build()
        setInstance(this)
    }


    companion object {

        private lateinit var app: App
        private fun setInstance(app: App) {
            this.app = app
        }

        fun getInstance() = app
    }
}