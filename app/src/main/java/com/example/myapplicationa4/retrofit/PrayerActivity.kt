package com.example.myapplicationa4.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationa4.R
import com.example.myapplicationa4.mvpAzhan.Contract
import com.example.myapplicationa4.mvpAzhan.presenterTest
import com.example.myapplicationa4.showToast
import kotlinx.android.synthetic.main.activity_prayer.*
import kotlinx.android.synthetic.main.activity_prayer.btnPrayerTime
import kotlinx.android.synthetic.main.activity_prayer.edtCity
import kotlinx.android.synthetic.main.activity_prayer.edtCountry
import java.text.SimpleDateFormat
import java.util.*


class PrayerActivity : AppCompatActivity(), Contract.View  {

    private val presenter = presenterTest(this)

    override fun showError() {
        this.showToast("Error in retrieving data")
    }



    override fun getCountryCity(): Pair<String, String> {
        val country = edtCountry.text.trim().toString()
        val city = edtCity.text.trim().toString()
        return country to city
    }

    override fun showPrayerTime(prayerTimings: Timings?) {
        txtFajr2.text =  prayerTimings?.Fajr
        txtSunrise2.text = prayerTimings?.Sunrise
        txtDhuhur2.text = prayerTimings?.Dhuhr
        txtSunset2.text =  prayerTimings?.Sunset
        txtGhroub.text =  prayerTimings?.Maghrib
        txtMidnight2.text = prayerTimings?.Midnight
    }

    override fun showUserTime() {
        val currentTime = Calendar.getInstance().time
        val df = SimpleDateFormat("HH:mm")
        val getPartsofDayByHour=presenter.getPartsofDayByHour(df.format(currentTime).dropLast(3))


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer)
        btnPrayerTime.setOnClickListener {
            presenter.onPrayerButtonClicked()
        }
    }
}