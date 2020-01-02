package com.marketpulse.scans.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.marketpulse.networking.ServiceInstance
import com.marketpulse.scans.models.ScansModel
import io.reactivex.schedulers.Schedulers

class ScansRepo(context: Context)
{
    companion object {
        var INSTANCE: ScansRepo? = null

        fun getInstance(context: Context): ScansRepo? {
            if (INSTANCE == null) {
                INSTANCE = ScansRepo(context = context)

            }
            return INSTANCE
        }
    }

    fun getScansList():MutableLiveData<ArrayList<ScansModel>>
    {
        var scansResponseModel=MutableLiveData<ArrayList<ScansModel>>()
        ServiceInstance.service?.getScansList()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(Schedulers.io())
            ?.subscribe({ response ->

            scansResponseModel.postValue(response as ArrayList<ScansModel>?)

                Log.d("Response",""+response)
            }, {

                Log.d("Error",""+it.localizedMessage+it.message)
            })

        return scansResponseModel
    }



}