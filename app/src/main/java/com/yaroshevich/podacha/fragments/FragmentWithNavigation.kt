package com.yaroshevich.podacha.fragments

import android.content.Context
import com.yaroshevich.podacha.interfaces.Navigator

abstract class FragmentWithNavigation: BaseFragment() {

    var navigator: Navigator? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = context as Navigator
    }
}