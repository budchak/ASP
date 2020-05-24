package com.yaroshevich.podacha.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yaroshevich.podacha.repositories.PanelRepository
import com.yaroshevich.podacha.repositories.SessionRepository
import com.yaroshevich.podacha.repositories.WorkRepository
import com.yaroshevich.podacha.room.entities.Panel
import com.yaroshevich.podacha.room.entities.Session
import com.yaroshevich.podacha.room.entities.Work
import java.util.*

class WorkViewModel : ViewModel() {

    val repository: WorkRepository = WorkRepository()
    val panelRepository: PanelRepository = PanelRepository()

    var isCreate = true

    fun getPanelList() = panelRepository.getAll()

    fun getPanel(id: Int) = panelRepository.getById(id)

    fun addPanel(panel: Panel) {
        panelRepository.create(panel)
    }

    fun getWork(): LiveData<List<Work>>? = liveWorkList

    fun getTempWork() = liveWork

    fun setWork() {
        liveWork.value = work2
    }

    fun loadWorkList(id: Int){
        isCreate = false
        liveWorkList.value =  repository.getAllBySessionId(id)
    }

    fun clearWorkList(){
        isCreate = true
        liveWorkList.value  = mutableListOf()
    }

    var workList = mutableListOf<Work>()
    var liveWorkList = MutableLiveData<List<Work>>()
    var id = 0
    var sessionRepository = SessionRepository()

    var work2 = Work(0, 0, 0, 0, 0)

    var liveWork = MutableLiveData<Work>()


    fun setPanelId(id: Int) {
        work2.panelId = id
        setWork()
    }

    fun setPanelColor(color: Int){
        work2.color = color
    }

    fun setPanelNumber(number: Int) {
        work2.number = number
        setWork()
    }

    fun setSessionID(id: Int) {
        work2.sessionID = id
        setWork()
    }


    fun saveSession() {
        createSession()
        val id = sessionRepository.getMaxId()
        for (w in workList) {
            if (id != null) {
                w.sessionID = id
            }
            repository.create(w)

        }
        workList = mutableListOf()
        liveWorkList.value = workList

    }

    fun createSession() {
        sessionRepository.create(Session(0, "Подача", Calendar.getInstance().time.toString()))

    }

    fun addPanel() {
        workList.add(work2)
        liveWorkList.value = workList
        work2 = Work(0, 0, 0, 0, 2)
    }
}

