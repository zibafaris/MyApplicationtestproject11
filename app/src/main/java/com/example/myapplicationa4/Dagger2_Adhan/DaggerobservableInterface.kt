package com.example.myapplicationa4.Dagger2_Adhan

import com.example.myapplicationa4.retrofit.jsonClass
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface DaggerobservableInterface {
    @GET("timingsByCity")
    fun getTimings(@Query("city")city: String,
                   @Query("country")country: String,
                   @Query("method")method: Int)
            : Observable<jsonClass>

}