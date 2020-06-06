package com.yaroshevich.podacha.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var isToolbarVisible: MutableLiveData<Boolean> = MutableLiveData()



    var dialogStatus: Int = 0

    fun setToolbarVisibility(isVisible: Boolean){
        isToolbarVisible.value = isVisible
    }



}