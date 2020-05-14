package com.yaroshevich.podacha.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Session(@PrimaryKey
              var id: Int, var name: String, var date: String) {


}