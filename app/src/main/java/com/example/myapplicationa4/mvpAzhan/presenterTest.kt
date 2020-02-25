package com.example.myapplicationa4.mvpAzhan

import com.example.myapplicationa4.retrofit.PrayerActivity
import com.example.myapplicationa4.retrofit.Timings


class presenterTest(private val view: PrayerActivity):Contract.Presenter {

    override fun getPartsofDayByHour(time: String): String {
        val hour=time.toInt()
        var result=when(hour){
            in 5..11 -> {"morning"}
            in 12..16-> {"noon"}
            in 17..19 ->{"sunset"}
            else ->{"night"}
        }
        return result
    }

    override fun onRetrofitResponse(isSucceed: Boolean, parayerTiming: Timings?) {
        if(isSucceed)
            view.showPrayerTime(parayerTiming)
        else
            view.showError()
    }

    val model=ModelTest(this)

    override fun onPrayerButtonClicked() {
        val (country, city)=view.getCountryCity()
        model.getPrayTimeData(city, country)

    }
}