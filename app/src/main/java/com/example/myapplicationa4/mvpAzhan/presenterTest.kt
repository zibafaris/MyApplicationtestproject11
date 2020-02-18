package com.example.myapplicationa4.mvpAzhan



class presenterTest(private val view:Contract.parentView):Contract.Presenter {
    val model=ModelTest(this)

    override fun btnSearchCityClicked() {
        val countryAndCity=  (view as Contract.SearchView).getCountryAndCity()
        model.fillTimes(countryAndCity.second,countryAndCity.first)
    }

    override fun btnTimesClicked() {
        (view as Contract.MainView).openDrawer()
    }

    override fun BtnSearchClicked() {
        (view as Contract.MainView).OpenSearchPage()
    }

    override fun showResultPage(){
        (view as Contract.SearchView).OpenResultPage(model)
    }
}
