package com.yaroshevich.podacha.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.adapters.WorkAdapter
import com.yaroshevich.podacha.adapters.WorkHeaderHolder
import com.yaroshevich.podacha.interfaces.Navigator
import com.yaroshevich.podacha.models.PodachaItem
import com.yaroshevich.podacha.room.entities.Work
import com.yaroshevich.podacha.viewModel.WorkViewModel
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : FragmentWithNavigation(), WorkHeaderHolder.Click{




    override fun click() {
        Toast.makeText(context, "ntrcn", Toast.LENGTH_SHORT).show()
        navigator?.navigate(R.id.panelDetailFragment)
        //context?.let { createDialog(it) }

    }

    fun createDialog(context: Context) {


        val builder = AlertDialog.Builder(context)

        val view = layoutInflater.inflate(R.layout.dialog_add_work_element, null, false)


        builder.apply {
            setTitle("Модель")
            setView(view)


            setPositiveButton(android.R.string.yes) { dialog, which ->


            }

            setNegativeButton(android.R.string.no) { dialog, which ->

            }

            show()
        }

    }

    private val model: WorkViewModel by activityViewModels()


    override fun getLayout() = R.layout.fragment_work


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = WorkAdapter()
        adapter.setListener(this@WorkFragment)
        recyclerView.apply {

            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)

        }
        model.getWork()?.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })






    }


}