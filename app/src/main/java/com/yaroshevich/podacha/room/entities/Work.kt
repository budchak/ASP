package com.yaroshevich.podacha.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Work(@PrimaryKey(autoGenerate = true) var id: Int = 0,var panelId: Int,var number: Int, var color: Int, var sessionID: Int) {

}