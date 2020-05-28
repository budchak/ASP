package com.yaroshevich.podacha.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yaroshevich.podacha.room.entities.Session
import com.yaroshevich.podacha.room.entities.Time

@Dao
interface TimeDao {

    @Query("SELECT * FROM time")
    fun getAll(): LiveData<List<Time>>

    @Query("SELECT * FROM time WHERE id = :id")
    fun getById(id: Long): Time

    @Insert
    fun insert(employee: Time)

    @Update
    fun update(employee: Time)

    @Delete
    fun delete(employee: Time)
}