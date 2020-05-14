package com.yaroshevich.podacha.room.dao

import androidx.room.*
import com.yaroshevich.podacha.room.entities.Session


@Dao
interface SessionDao {

    @Query("SELECT * FROM session")
    fun getAll(): List<Session>

    @Query("SELECT * FROM session WHERE id = :id")
    fun getById(id: Long): Session

    @Insert
    fun insert(employee: Session)

    @Update
    fun update(employee: Session)

    @Delete
    fun delete(employee: Session)
}