package com.yaroshevich.podacha.viewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yaroshevich.podacha.models.Session
import com.yaroshevich.podacha.models.Work
import com.yaroshevich.podacha.repositories.SessionRepository

class SessionViewModel: ViewModel() {

    var session = Session()
    val sessionRepository = SessionRepository()

    var liveWork = MutableLiveData<List<Work>>()

    fun createSession(){
        val maxID = sessionRepository.getMaxId()

    }

    fun getSessionList() = sessionRepository.getAll()

}