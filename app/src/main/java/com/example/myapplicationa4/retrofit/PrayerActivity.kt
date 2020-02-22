package com.example.myapplicationa4.retrofit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.myapplicationa4.R
import com.example.myapplicationa4.mvpAzhan.Contract
import com.example.myapplicationa4.mvpAzhan.ModelTest
import com.example.myapplicationa4.mvpAzhan.presenterTest
import com.example.myapplicationa4.showToast
import kotlinx.android.synthetic.main.activity_mvvm.*
import kotlinx.android.synthetic.main.activity_prayer.*
import kotlinx.android.synthetic.main.activity_search.*
import java.text.SimpleDateFormat
import java.util.*

class PrayerActivity : AppCompatActivity(), Contract.SearchView  {

    private val presenter = presenterTest(this)

     fun showError() {
        this.showToast("Error in retrieving data")
    }

    override fun OpenResultPage(model: ModelTest) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getCountryCity(): Pair<String, String> {
        val country = edtCountry.text.trim().toString()
        val city = edtCity.text.trim().toString()
        return country to city
    }

     override fun showPrayerTime(prayerTimings: Timings?) {
        txtFajr.text =  prayerTimings?.Fajr
        txtSunrise.text = prayerTimings?.Sunrise
        txtDhuhur.text = prayerTimings?.Dhuhr
        txtSunset.text =  prayerTimings?.Sunset
        txtMidnight.text = prayerTimings?.Midnight
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer)


        btnPrayerTime.setOnClickListener {
            presenter.onPrayerButtonClicked()
        }
    }


}
