package com.example.myapplicationa4.mvpAzhan

import com.example.myapplicationa4.retrofit.Timings


interface Contract {

    interface MainView{
        fun openDrawer()
        fun OpenSearchPage()
    }

    interface ResultView {

    }

    interface SearchView
    {
        fun OpenResultPage(model: ModelTest)
        fun getCountryCity(): Pair<String,String>
        fun showPrayerTime(prayerTimings: Timings?)


    }

    interface Presenter{
        fun btnSearchCityClicked()
        fun btnTimesClicked()
        fun BtnSearchClicked()
        fun showResultPage(results: Timings?)
        fun onPrayerButtonClicked()
    }
}