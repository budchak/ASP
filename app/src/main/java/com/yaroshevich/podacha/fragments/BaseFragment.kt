package com.yaroshevich.podacha.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    abstract fun getName(): String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e(getName(), "Create")
        return inflater.inflate(getLayout(), container, false)

    }


    @LayoutRes
    abstract fun getLayout():Int
}