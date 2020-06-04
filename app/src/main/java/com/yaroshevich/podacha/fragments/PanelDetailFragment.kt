package com.yaroshevich.podacha.fragments

import android.content.Context
import android.os.Bundle
import android.view.View

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.podacha.MainActivity
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.interfaces.ClickListenerID
import com.yaroshevich.podacha.viewModel.WorkViewModel
import kotlinx.android.synthetic.main.dialog_add_work_element.*
import kotlinx.android.synthetic.main.dialog_add_work_element.view.*
import kotlinx.android.synthetic.main.dialog_add_work_element.view.colorButton

class PanelDetailFragment : FragmentWithNavigation() {

    private var clickListenerID: ClickListenerID? = null
    lateinit var model: WorkViewModel
    override fun getName(): String {
        return "PanelDetailFragment"
    }

    override fun getLayout(): Int {
        return R.layout.dialog_add_work_element
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = (activity as MainActivity).model
        view.apply {
            nameButton.setOnClickListener {
                navigator?.navigate(R.id.panelListFragment)
            }
            colorButton.setOnClickListener {
                clickListenerID?.click(3)
            }
            applyButton.setOnClickListener {
                model.setPanelNumber(numberEditText.text.toString().toInt())
                model.addPanel()
                navigator?.navigate(R.id.workFragment)
            }

        }

        model.getTempWork()?.observe(viewLifecycleOwner, Observer {

            view.nameButton.setText((model.getPanel(it.panelId))?.name)
            colorButton.text = when(model.work2.color){
                1 -> "Белый"
                2 -> "серый"
                else -> "Белый"
            }
        })

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        clickListenerID = context as ClickListenerID
    }
}