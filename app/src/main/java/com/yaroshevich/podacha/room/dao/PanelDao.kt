package com.yaroshevich.podacha.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yaroshevich.podacha.room.entities.Panel

@Dao
interface PanelDao {

    @Query("SELECT * FROM panel")
    fun getAll(): LiveData<List<Panel>>

    @Query("SELECT * FROM panel WHERE id = :id")
    fun getById(id: Int): Panel

    @Insert
    fun insert(panel: Panel)

    @Update
    fun update(panel: Panel)

    @Delete
    fun delete(panel: Panel)
}