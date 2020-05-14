package com.yaroshevich.podacha


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.yaroshevich.podacha.fragments.AuthorizationFragment
import com.yaroshevich.podacha.fragments.WorkFragment
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yaroshevich.podacha.interfaces.Navigator


class MainActivity : AppCompatActivity(), Navigator {

    var navController: NavController? = null

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
            R.id.action_add -> navigate(R.id.workFragment)

        }

        return true
    }


    fun setStatusBarColor(color: Int) {
        val window = this.getWindow()

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        window.setStatusBarColor(this.getResources().getColor(R.color.colorReg))
    }


    override fun navigate(screen: Int) {
        when(screen){
            R.id.sessionFragment -> navigateToSessionScreen(screen)
            R.id.workFragment -> navigateToWorkScreen(screen)
            R.id.panelDetailFragment -> navigateToPanelDetailScreen(screen)
            R.id.panelListFragment -> navigateToPanelListScreen(screen)
        }
    }

    //Navigation
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    fun navigateToSessionScreen(id: Int){
        toolbar.background = getDrawable(R.color.colorReg)
        toolbar.visibility = View.VISIBLE
        setSupportActionBar(toolbar)
        navController?.navigate(id)

    }

    fun navigateToPanelDetailScreen(id: Int){
        navController?.navigate(id)
    }

    fun navigateToPanelListScreen(id: Int){
        navController?.navigate(id)
    }

    fun navigateToWorkScreen(id: Int){
        navController?.navigate(id)
    }

}
