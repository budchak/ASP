package com.yaroshevich.podacha.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.podacha.MainActivity
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.adapters.BaseAdapter
import com.yaroshevich.podacha.adapters.SessionAdapter
import com.yaroshevich.podacha.viewModel.MainViewModel
import com.yaroshevich.podacha.viewModel.SessionViewModel
import com.yaroshevich.podacha.viewModel.WorkViewModel
import kotlinx.android.synthetic.main.fragment_session.*

class SessionFragment : FragmentWithNavigation(), BaseAdapter.ItemClickListener {

    lateinit var model: WorkViewModel

    lateinit var mainActivityViewModel: MainViewModel
    lateinit var workSessionViewModel: SessionViewModel
    val sessionAdapter = SessionAdapter()


    override fun onItemClick(id: Int) {
        if (id == 555555) {
            sessionAdapter.items = model.sessionRepository.getAll()
            sessionAdapter.notifyDataSetChanged()
        } else {


            if (id == 666666) {
                model.loadWorkList(id)
                model.isCreate = true
                navigator?.navigate(R.id.workFragment)
                Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
            } else {
                model.loadWorkList(id)
                model.isCreate = false
                navigator?.navigate(R.id.workFragment)
                Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getName(): String {
        return "SessionFragment"
    }

    override fun getLayout() = R.layout.fragment_session


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModels()


        sessionAdapter.apply {
            setListener(this@SessionFragment)
            items = model.sessionRepository.getAll()
        }


        recuclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = sessionAdapter

        }

        mainActivityViewModel.setToolbarVisibility(true)
    }

    fun initViewModels() {

        model = (activity as MainActivity).model

        mainActivityViewModel = (activity as MainActivity).mainViewModel

        workSessionViewModel = (activity as MainActivity).workSessionViewModel

    }


}