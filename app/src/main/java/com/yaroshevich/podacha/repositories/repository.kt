package com.yaroshevich.podacha.repositories

interface repository<T> {



    fun getAll():List<T>

    fun create(item: T)

    fun update(item: T)

    fun delete(item: T)
}