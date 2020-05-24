package com.yaroshevich.podacha.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.interfaces.ClickListenerID
import com.yaroshevich.podacha.viewModel.WorkViewModel
import kotlinx.android.synthetic.main.dialog_add_work_element.view.*

class PanelDetailFragment: FragmentWithNavigation() {

    private var clickListenerID: ClickListenerID? = null
    private val model: WorkViewModel by activityViewModels()

    override fun getName(): String {
        return "PanelDetailFragment"
    }

    override fun getLayout(): Int {
        return R.layout.dialog_add_work_element
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            nameButton.setOnClickListener {
                navigator?.navigate(R.id.panelListFragment)
            }
            colorButton.setOnClickListener{
                clickListenerID?.click(3)
            }
            applyButton.setOnClickListener {

                model.addPanel()
                navigator?.navigate(R.id.workFragment)
            }

        }

        model.getTempWork()?.observe(viewLifecycleOwner, Observer {

           view.nameButton.setText((model.getPanel(it.panelId))?.name)
        })

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        clickListenerID = context as ClickListenerID
    }
}