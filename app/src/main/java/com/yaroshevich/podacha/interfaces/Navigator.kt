package com.yaroshevich.podacha.interfaces

import androidx.annotation.IdRes


interface Navigator {


    fun navigate(@IdRes screen: Int)

}