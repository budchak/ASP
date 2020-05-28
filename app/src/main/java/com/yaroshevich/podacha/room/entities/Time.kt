package com.yaroshevich.podacha.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Time(@PrimaryKey(autoGenerate = true) var id: Int = 0, var time: String, var eventType: Int, var workId: Int)
