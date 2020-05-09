package com.yaroshevich.podacha.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.yaroshevich.podacha.models.Login

class LoginViewModel(): ViewModel() {

    var list = mutableListOf<Login>()



}