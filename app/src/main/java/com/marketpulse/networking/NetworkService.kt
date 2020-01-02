package com.marketpulse.networking


import com.marketpulse.scans.models.ScansModel
import io.reactivex.Single
import retrofit2.http.*


interface NetworkService {

    @GET("data")
    fun getScansList(): Single<List<ScansModel>>


}