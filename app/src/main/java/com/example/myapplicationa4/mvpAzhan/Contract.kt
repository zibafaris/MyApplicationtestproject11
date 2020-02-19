package com.example.myapplicationa4.mvpAzhan

import com.example.myapplicationa4.retrofit.Timings


interface Contract {

    interface MainView{
        fun openDrawer()
        fun OpenSearchPage()
    }

    interface ResultView {}

    interface SearchView
    {
        fun getCountryAndCity():Pair<String,String>
        fun OpenResultPage(model: ModelTest)
    }

    interface Presenter{
        fun btnSearchCityClicked()
        fun btnTimesClicked()
        fun BtnSearchClicked()
        fun showResultPage(results: Timings?)
    }
}