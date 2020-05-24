package com.yaroshevich.podacha.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.adapters.BaseAdapter
import com.yaroshevich.podacha.adapters.PanelAdapter
import com.yaroshevich.podacha.interfaces.ClickListenerID
import com.yaroshevich.podacha.viewModel.WorkViewModel
import kotlinx.android.synthetic.main.fragment_list_panel.*

class PanelListFragment : FragmentWithNavigation(), BaseAdapter.ItemClickListener{

    var clickListenerID: ClickListenerID? = null

    private val model: WorkViewModel by activityViewModels()

    override fun getLayout(): Int =
        R.layout.fragment_list_panel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = clickListenerID?.let { PanelAdapter(it) }
        adapter?.setListener(this)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

        model.getPanelList()?.observe(viewLifecycleOwner, Observer {
            adapter?.additems(it)
        })
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        clickListenerID = context as ClickListenerID
    }

    override fun getName(): String {
       return "PanelListFragment"
    }


    override fun onItemClick(id: Int) {
        model.setPanelId(id)
        Toast.makeText(context, id.toString(), Toast.LENGTH_LONG).show()
        navigator?.navigate(R.id.panelDetailFragment)
    }



}

