package com.yaroshevich.podacha


import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yaroshevich.podacha.adapters.BaseAdapter
import com.yaroshevich.podacha.interfaces.ClickListenerID
import com.yaroshevich.podacha.interfaces.Navigator
import com.yaroshevich.podacha.room.entities.Panel
import com.yaroshevich.podacha.viewModel.SessionViewModel
import com.yaroshevich.podacha.viewModel.WorkViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add_panel.view.*
import kotlinx.android.synthetic.main.dialog_add_work_element.view.*


class MainActivity : AppCompatActivity(), Navigator, ClickListenerID,
    BaseAdapter.ItemClickListener {

    var navController: NavController? = null
    private val model: WorkViewModel by viewModels()
    private val workSessionViewModel: SessionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)



        toolbar.visibility = View.GONE
        setStatusBarColor(1)
        //
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_add -> {
                // model.isCreate = true
                //  model.clearWorkList()

                workSessionViewModel.createSession()
                navigate(R.id.workFragment)
            }

        }

        return true
    }


    fun setStatusBarColor(color: Int) {
        val window = this.getWindow()

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        window.setStatusBarColor(this.getResources().getColor(R.color.colorReg))
    }


    //Navigation
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun navigate(screen: Int) {
        when (screen) {
            R.id.sessionFragment -> navigateToSessionScreen(screen)

            R.id.workFragment -> navigateToWorkScreen(screen)
            R.id.panelDetailFragment -> navigateToPanelDetailScreen(screen)
            R.id.panelListFragment -> navigateToPanelListScreen(screen)
        }
    }

    fun navigateToSessionScreen(id: Int) {
        navController?.navigate(id)
        toolbar.background = getDrawable(R.color.colorReg)
        toolbar.visibility = View.VISIBLE
        setSupportActionBar(toolbar)


    }

    fun navigateToPanelDetailScreen(id: Int) {
        navController?.navigate(id)
    }

    fun navigateToPanelListScreen(id: Int) {
        navController?.navigate(id)
    }

    fun navigateToWorkScreen(id: Int) {
        navController?.navigate(id)
    }

    fun navigateToAddPanelDialog(id: Int) {
        navController?.navigate(id)
    }


    //listeners
    /////////////////////////////////////////////////////////

    override fun click(id: Int) {
        when (id) {
            1 -> true
            2 -> createAddPanelDialog()
            3 -> chooseColorDialog()

        }
    }

    override fun onItemClick(id: Int) {
        TODO("Not yet implemented")
    }

    //Dialogs
    ///////////////////////////////////////////////////////////////////

    private fun createAddPanelDialog() {
        val dialog = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_add_panel, null, false)
        dialog.apply {
            setView(view)
            setPositiveButton(
                "Принять",
                DialogInterface.OnClickListener() { dialogInterface: DialogInterface, i: Int ->
                    model.addPanel(Panel(0, view.name.text.toString()))
                })

        }

        dialog.show()
    }

    private fun chooseColorDialog(){
        val dialog = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_choise_color, null, false)
        dialog.apply {
            setView(view)
            setPositiveButton(
                "Принять",
                DialogInterface.OnClickListener() { dialogInterface: DialogInterface, i: Int ->

                    model.setPanelColor(1)
                })

        }

        dialog.show()
    }
}
