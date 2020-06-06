package com.yaroshevich.podacha.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yaroshevich.podacha.room.entities.Time

@Dao
interface TimeDao {

    @Query("SELECT * FROM time")
    fun getAll(): List<Time>

    @Query("SELECT * FROM time WHERE workId = :id")
    fun getById(id: Int): List<Time>

    @Insert
    fun insert(employee: Time)

    @Update
    fun update(employee: Time)

    @Delete
    fun delete(employee: Time)

    @Delete
    fun delete(time: List<Time>)
}