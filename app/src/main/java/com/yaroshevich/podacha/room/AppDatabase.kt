package com.yaroshevich.podacha.room

import androidx.room.RoomDatabase
import androidx.room.Database
import com.yaroshevich.podacha.room.dao.PanelDao
import com.yaroshevich.podacha.room.dao.SessionDao
import com.yaroshevich.podacha.room.dao.WorkDao
import com.yaroshevich.podacha.room.entities.Panel
import com.yaroshevich.podacha.room.entities.Session
import com.yaroshevich.podacha.room.entities.Work


@Database(entities = [Session::class, Work::class, Panel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sessionDao(): SessionDao
    abstract fun workDao(): WorkDao
    abstract fun panelDao(): PanelDao
}