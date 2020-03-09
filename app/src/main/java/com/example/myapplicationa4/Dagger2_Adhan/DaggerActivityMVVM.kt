package com.example.myapplicationa4.Dagger2_Adhan

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationa4.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_prayer.*
import kotlinx.android.synthetic.main.activity_prayer.txtFajr
import kotlinx.android.synthetic.main.activity_prayer.txtMidnight
import kotlinx.android.synthetic.main.activity_prayer.txtSunrise
import kotlinx.android.synthetic.main.activity_prayer.txtSunset
import kotlinx.android.synthetic.main.activity_result.*

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
                txtSunrise.text = "tolu : "+intent.getStringExtra("tolu")
                txtFajr.text = " Sobh : "+ intent.getStringExtra("Sobh")
                txtDhuhr.text = " Zohr : "+intent.getStringExtra("Zohr")
                txtSunset.text = "Ghroub : "+intent.getStringExtra("ghroub")
                txtGhroub.text = "Maghroub : "+intent.getStringExtra("ghorub")
                txtMidnight.text = "Nime Shab : "+intent.getStringExtra("nimeshab")
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
