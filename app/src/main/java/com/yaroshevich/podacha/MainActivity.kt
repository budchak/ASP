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


class MainActivity : AppCompatActivity() {

    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AuthorizationFragment())
            .commit()

        toolbar.visibility = View.GONE
        setStatusBarColor(1)
        // setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_add -> supportFragmentManager.beginTransaction().replace(
                R.id.container,
                WorkFragment()
            ).commit()
        }

        return true
    }


    fun setStatusBarColor(color: Int) {
        val window = this.getWindow()


        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
        window.setStatusBarColor(this.getResources().getColor(R.color.colorReg))
    }
}
