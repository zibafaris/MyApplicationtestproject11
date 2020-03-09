package com.example.myapplicationa4.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationa4.R
import com.example.myapplicationa4.mvpAzhan.Contract
import kotlinx.android.synthetic.main.activity_prayer.*

class ResultActivity : AppCompatActivity(), Contract{

    @SuppressLint("NewApi", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer)
        var intent = getIntent()

        txtSunrise2.text = "tolu : "+intent.getStringExtra("tolu")
        txtFajr2.text = " Sobh : "+ intent.getStringExtra("Sobh")
        txtDhuhur2.text = " Zohr : "+intent.getStringExtra("Zohr")
        txtSunset2.text = "Ghroub : "+intent.getStringExtra("ghroub")
        txtGhroub.text = "Maghroub : "+intent.getStringExtra("ghorub")
        txtMidnight2.text = "Nime Shab : "+intent.getStringExtra("nimeshab")


    }
}
