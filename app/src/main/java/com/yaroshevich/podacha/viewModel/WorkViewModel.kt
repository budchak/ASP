package com.yaroshevich.podacha.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yaroshevich.podacha.repositories.WorkRepository
import com.yaroshevich.podacha.room.entities.Work

class WorkViewModel: ViewModel() {

    val repository: WorkRepository = WorkRepository()
    var list: LiveData<List<Work>>? = null



    fun getWork(): LiveData<List<Work>>? = repository.getAll()

    fun setWork(work: Work){
        repository.create(work)
    }

}