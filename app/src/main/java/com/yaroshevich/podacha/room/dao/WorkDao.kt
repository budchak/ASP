package com.yaroshevich.podacha.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yaroshevich.podacha.room.entities.Work


@Dao
interface WorkDao {

    @Query("SELECT * FROM work")
    fun getAll(): LiveData<List<Work>>

    @Query("SELECT * FROM work WHERE id = :id")
    fun getById(id: Long): Work

    @Query("SELECT * FROM work WHERE sessionID = :sessionID")
    fun getBySessionId(sessionID: Int):List<Work>

    @Insert
    fun insert(work: Work)

    @Update
    fun update(work: Work)

    @Delete
    fun delete(work: Work)

    @Delete
    fun delete(employee: List<Work?>?): Int
}