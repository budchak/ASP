package com.yaroshevich.podacha.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.adapters.PanelAdapter
import kotlinx.android.synthetic.main.fragment_list_panel.*

class PanelListFragment : BaseFragment() {

    override fun getLayout(): Int =
        R.layout.fragment_list_panel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PanelAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
    }
}