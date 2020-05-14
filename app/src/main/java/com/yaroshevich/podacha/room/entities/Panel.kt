package com.yaroshevich.podacha.room.entities

import androidx.annotation.IdRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Panel(@PrimaryKey(autoGenerate = true)var id: Int = 0, var name: String)