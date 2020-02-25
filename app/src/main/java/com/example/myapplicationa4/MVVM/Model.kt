package com.example.firstkotlinapp.mvvm

import com.example.myapplicationa4.retrofit.jsonClass
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import io.reactivex.Observable as Observable1

class Model {

    private fun getPrayTimeData(): ObservableRetrofit {
        val retrofit= Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(ObservableRetrofit::class.java)
    }

    fun getAdhanObservable(country: String, city: String): Observable1<jsonClass> {

        return getPrayTimeData().getTimings(city,country,8)
    }
}