package com.yaroshevich.podacha.fragments

import android.os.Bundle
import android.view.View
import com.yaroshevich.podacha.R

class PanelDetailFragment: FragmentWithNavigation() {


    override fun getLayout(): Int {
        return R.layout.dialog_add_work_element
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {

        }
    }
}