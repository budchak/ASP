package com.yaroshevich.podacha.fragments


import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yaroshevich.podacha.App
import com.yaroshevich.podacha.R
import com.yaroshevich.podacha.models.Login
import kotlinx.android.synthetic.main.fragment_authorization.view.*

class AuthorizationFragment : BaseFragment() {


    override fun getLayout(): Int =
        R.layout.fragment_authorization


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var app = activity?.application as App

        view.apply {
            forgotButton.setOnClickListener {

            }

            registrationButton.setOnClickListener {

            }

            loginButton.setOnClickListener {
                val login = loginEditText.text.toString()
                val password = passwordEditText.text.toString()
                Toast.makeText(activity, app.loginManager.isFind(Login(login, password)).toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()

    }
}