package com.example.myapplicationa4.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationa4.R
import com.example.myapplicationa4.mvpAzhan.Contract
import com.example.myapplicationa4.mvpAzhan.ModelTest
import com.example.myapplicationa4.mvpAzhan.presenterTest
import kotlinx.android.synthetic.main.activity_search.*

class PrayerActivity : AppCompatActivity(), Contract.SearchView  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val presenter= presenterTest(this)
        btnreview.setOnClickListener{
            presenter.btnSearchCityClicked()

        }
    }
    override fun getCountryAndCity(): Pair<String, String> {
        val country=edtcountry.text.toString()
        val city=edtcity.text.toString()
        return city to country
    }

    override fun OpenResultPage(model: ModelTest) {
        var intent = Intent(this, ResultActivity::class.java)

        intent.putExtra("tolu",model.tolu)
        intent.putExtra("azanSobh",model.Sobh)
        intent.putExtra("azanZohr",model.Zohr)
        intent.putExtra("ghorub",model.ghorub)
        intent.putExtra("maghrib",model.maghrib)
        intent.putExtra("nimeshab",model.nimeshab)

        startActivity(intent)
    }


}
