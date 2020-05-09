package com.yaroshevich.podacha.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.adapters.WorkAdapter
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment: BaseFragment() {

    override fun getLayout() = R.layout.fragment_work


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.apply {
            adapter = WorkAdapter()
            layoutManager = LinearLayoutManager(context)
        }



    }
}