package com.marketpulse.scans.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.marketpulse.scans.models.ScansModel
import com.marketpulse.scans.repo.ScansRepo

class ScansVM (application: Application) : AndroidViewModel(application) {


    private val mScansRepo: ScansRepo? = ScansRepo.getInstance(application.applicationContext)



    fun getScansList(): MutableLiveData<ArrayList<ScansModel>>?
    {
        return mScansRepo?.getScansList()
    }
}
