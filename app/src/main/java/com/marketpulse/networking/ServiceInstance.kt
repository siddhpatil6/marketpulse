package com.marketpulse.networking

object ServiceInstance {
    private var serviceInstance: NetworkService? = null

    val service: NetworkService?
        get() {
            if (serviceInstance == null) {
                return RetrofitInstance.retrofitInstance.create(NetworkService::class.java)
            }
            return serviceInstance
        }
}