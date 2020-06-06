package com.yaroshevich.podacha.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToolbarViewModel: ViewModel() {

    var isToolbarVisible: MutableLiveData<Boolean> = MutableLiveData()

    var statusBarColor = 1

    var toolbarType = MutableLiveData<Int>()



}