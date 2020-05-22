package com.yaroshevich.podacha.models

import java.util.*


class Session() {

    private var name = ""
    private var date = Calendar.getInstance().time

    private var workList: MutableList<Work> = mutableListOf()


    fun setName(name: String) {
        this.name = name
    }

    fun setdate(date: Date) {
        this.date = date
    }

    fun addWork(work: Work){
        workList.add(work)
    }

}