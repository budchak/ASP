package com.yaroshevich.podacha.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.adapters.WorkAdapter
import com.yaroshevich.podacha.adapters.WorkHeaderHolder
import com.yaroshevich.podacha.viewModel.WorkViewModel
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : FragmentWithNavigation(), WorkHeaderHolder.Click {

    private val model: WorkViewModel by activityViewModels()


    //слушатель для обратки нажатий на хедер списка
    override fun click() {
        Toast.makeText(context, "ntrcn", Toast.LENGTH_SHORT).show()
        navigator?.navigate(R.id.panelDetailFragment)


    }

    override fun getName(): String {
        return "WorkFragment"
    }

    override fun getLayout() = R.layout.fragment_work


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WorkAdapter(requireActivity().applicationContext)

        adapter.apply {
            setListener(this@WorkFragment)
            isHeaderVisible = model.isCreate // set visibility header in recycler view
        }

        model.getWork()?.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })



        recyclerView.apply {

            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)

        }
        applyButton.apply {
            when (model.isCreate) {
                true -> visibility = View.VISIBLE
                false -> visibility = View.GONE
            }

            setOnClickListener {
                model.saveSession()
                navigator?.navigate(R.id.sessionFragment)
            }
        }


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
}