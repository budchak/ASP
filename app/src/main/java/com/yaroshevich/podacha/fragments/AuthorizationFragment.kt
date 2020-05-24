package com.yaroshevich.podacha.fragments


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yaroshevich.podacha.App
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.interfaces.Navigator
import com.yaroshevich.podacha.models.Login
import kotlinx.android.synthetic.main.fragment_authorization.view.*

class AuthorizationFragment : BaseFragment() {


    var navigator: Navigator? = null

    override fun getName(): String {
        return "AuthorizationFragment"
    }

    override fun getLayout(): Int =
        R.layout.fragment_authorization


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var app = activity?.application as App

        view.apply {



            loginButton.setOnClickListener {
                val login = loginEditText.text.toString()
                val password = passwordEditText.text.toString()
                Toast.makeText(activity, app.loginManager.isFind(Login(login, password)).toString(), Toast.LENGTH_SHORT)
                    .show()
                navigator?.navigate(R.id.sessionFragment)
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = context as Navigator
    }


}