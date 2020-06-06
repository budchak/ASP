package com.yaroshevich.podacha.viewModel

import androidx.lifecycle.MutableLiveData

class ToolbarViewModel {

    var isToolbarVisible: MutableLiveData<Boolean> = MutableLiveData()

    var toolbarType = MutableLiveData<Int>()
}