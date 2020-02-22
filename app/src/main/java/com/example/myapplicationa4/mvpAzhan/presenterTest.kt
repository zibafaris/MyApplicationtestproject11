package com.example.myapplicationa4.mvpAzhan

import com.example.myapplicationa4.retrofit.PrayerActivity
import com.example.myapplicationa4.retrofit.Timings


class presenterTest(private val view: PrayerActivity):Contract.Presenter {
    val model=ModelTest(this)

    override fun btnSearchCityClicked() {
        val countryAndCity=  (view as Contract.SearchView).getCountryCity()
        model.fillTimes(countryAndCity.second,countryAndCity.first)
    }

    override fun btnTimesClicked() {
        (view as Contract.MainView).openDrawer()
    }

    override fun BtnSearchClicked() {
        (view as Contract.MainView).OpenSearchPage()
    }

    override fun showResultPage(results: Timings?) {
        (view as Contract.SearchView).OpenResultPage(model)
    }

    override fun onPrayerButtonClicked() {
        val (country, city)=view.getCountryCity()
        model.fillTimes(city, country)    }
}
