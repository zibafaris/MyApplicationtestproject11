package com.example.myapplicationa4.Dagger2_Adhan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationa4.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_prayer.*


class DaggerActivityMVVM : AppCompatActivity() {
    lateinit var viewModel: DaggerViewModelAladhan
    private val disposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer)
        val factory = DaggerFactoryComponentMVVM.create().provideVMFactory()
        viewModel = ViewModelProvider(this, factory).get(DaggerViewModelAladhan::class.java)

        btnPrayerTime.setOnClickListener {
            viewModel.setOnClick(getCityCountry().first,getCityCountry().second)
            viewModel.getLiveData().observe(this, Observer {
                txtFajr2.text = "tolu : "+intent.getStringExtra("tolu")
                txtSunrise2.text = " Sobh : "+ intent.getStringExtra("Sobh")
                txtDhuhur2.text = " Zohr : "+intent.getStringExtra("Zohr")
                txtSunset2.text = "Ghroub : "+intent.getStringExtra("ghroub")
                txtGhroub.text = "Maghroub : "+intent.getStringExtra("ghorub")
                txtMidnight2.text = "Nime Shab : "+intent.getStringExtra("nimeshab")
            })


        }

    }

    fun getCityCountry():Pair<String,String>{
        val city=edtCity.text.toString()
        val country=edtCountry.text.toString()
        return city to country
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
