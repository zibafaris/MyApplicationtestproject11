package com.example.myapplicationa4.mvpAzhan

import com.example.myapplicationa4.retrofit.Timings


interface Contract {

    interface View{
        fun getCountryCity(): Pair<String,String>
        fun showPrayerTime(prayerTimings: Timings?)
        fun showError()

    }
    interface Presenter{
        fun onPrayerButtonClicked()
        fun onRetrofitResponse(isSucceed: Boolean, prayerTimings: Timings?)
        fun getDayByHour(time: String):String

    }
}