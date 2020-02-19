package com.example.myapplicationa4.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationa4.R
import com.example.myapplicationa4.mvpAzhan.Contract
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(), Contract.ResultView{

    @SuppressLint("NewApi", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var intent = getIntent()

        txtSunrise.text = "tolu : "+intent.getStringExtra("tolu")
        txtFajr.text = " Sobh : "+ intent.getStringExtra("Sobh")
        txtDhuhr.text = " Zohr : "+intent.getStringExtra("Zohr")
        txtSunset.text = "Ghroub : "+intent.getStringExtra("ghroub")
        txtGhroub.text = "Maghroub : "+intent.getStringExtra("ghorub")
        txtMidnight.text = "Nime Shab : "+intent.getStringExtra("nimeshab")


    }
}
