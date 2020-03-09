package com.example.myapplicationa4.Dagger2_Adhan

import com.example.myapplicationa4.retrofit.jsonClass
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class DaggerModelAladhan @Inject constructor() {


    fun setAdhanDagger(): DaggerobservableInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(DaggerobservableInterface::class.java)
    }

    fun setAdhanDaggerObservable(country: String, city: String): Observable<jsonClass>
    {
        return setAdhanDagger().getTimings(city,country,8)
    }

}