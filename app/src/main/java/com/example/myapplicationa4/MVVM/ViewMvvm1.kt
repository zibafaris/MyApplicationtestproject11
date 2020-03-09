package com.example.myapplicationa4.MVVM

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstkotlinapp.mvvm.ViewModel
import com.example.myapplicationa4.R
import com.example.myapplicationa4.retrofit.Timings
import kotlinx.android.synthetic.main.activity_mvvm.*
import kotlinx.android.synthetic.main.activity_prayer.*

class ViewMvvm : AppCompatActivity(){
    val myViewModel= ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
        btnPrayerTime.setOnClickListener {
            myViewModel.onPrayerButtonClicked(getCountryCity().first,getCountryCity().second)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        myViewModel.clearDisposable()
    }


    fun getCountryCity(): Pair<String, String> {
        val country = edtCountry2.text.trim().toString()
        val city = edtCity2.text.trim().toString()
        return country to city
    }

    fun showPrayerTime(prayerTimings: Timings?) {
        txtFajr2.text =  prayerTimings?.Fajr
        txtSunrise2.text = prayerTimings?.Sunrise
        txtDhuhur2.text = prayerTimings?.Dhuhr
        txtSunset2.text =  prayerTimings?.Sunset
        txtMidnight2.text = prayerTimings?.Midnight
    }

}