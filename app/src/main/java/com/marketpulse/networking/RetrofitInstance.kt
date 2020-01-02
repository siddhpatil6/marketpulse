package com.marketpulse.networking

import android.content.Context
import com.google.gson.GsonBuilder

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


object RetrofitInstance  {


    private var retrofit: Retrofit? = null


    private val URL = "https://mp-android-challenge.herokuapp.com/"





    val retrofitInstance: Retrofit
        get() {
            val okHttpClient = OkHttpClient.Builder()

            val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }

            okHttpClient.addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original = chain.request()
                    val request = original.newBuilder()
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body())
                        .build()
                    return chain.proceed(request)
                }
            })
            okHttpClient.readTimeout(10, TimeUnit.SECONDS)
            okHttpClient.connectTimeout(10, TimeUnit.SECONDS)

            okHttpClient.addInterceptor(interceptor)

            val gson = GsonBuilder()
                .setLenient()
                .create()

            retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

    return retrofit!!
}

}




