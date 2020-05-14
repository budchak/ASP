package com.yaroshevich.podacha.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.adapters.BaseAdapter
import com.yaroshevich.podacha.adapters.SessionAdapter
import com.yaroshevich.podacha.models.Session
import com.yaroshevich.podacha.repositories.SessionRepository
import kotlinx.android.synthetic.main.fragment_session.*

class SessionFragment : BaseFragment(), BaseAdapter.ItemClickListener {


    override fun onItemClick(id: Int) {
        Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
    }

    override fun getLayout() = R.layout.fragment_session


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SessionAdapter()
        adapter.apply {
            listener = this@SessionFragment
            items = SessionRepository().getAll() as MutableList<Session>
        }


        recuclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter

        }
    }



}