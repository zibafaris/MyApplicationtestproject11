package com.example.firstkotlinapp.mvvm


import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ViewModel {
    val disposable=CompositeDisposable()
    val model= Model()


     fun onPrayerButtonClicked(country:String,city:String) {
        //val (country, city)=view.getCountryCity()

         disposable.add(model.getAdhanObservable(country,city)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe({
                 val result=it.data.timings
                 //send result to view

             },{
                 val error=it.message
                 //send error to view
             }))
    }

    fun clearDisposable(){
        disposable.dispose()
    }
}