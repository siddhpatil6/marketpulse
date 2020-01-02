package com.marketpulse.networking

interface APIInterface<T>
{
    fun onResponse(response:T)
    fun onError()
}