package com.yaroshevich.podacha.viewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yaroshevich.podacha.models.Work
import com.yaroshevich.podacha.models.WorkSession
import com.yaroshevich.podacha.repositories.SessionRepository

class SessionViewModel : ViewModel() {

    private var session: WorkSession? = null
        get() = session



    val sessionRepository = SessionRepository()


    var liveWork = MutableLiveData<List<Work>>()

    fun createSession() {
        session = WorkSession()
    }

    fun addWork(work: Work){
        session?.addWork(work)
    }


}