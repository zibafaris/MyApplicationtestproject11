package com.example.myapplicationa4.Dagger2_Adhan

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationa4.R
import io.reactivex.disposables.CompositeDisposable

class DaggerActivityMVVM : AppCompatActivity() {
    lateinit var viewModel: DaggerViewModelAladhan
    private val disposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_mvvm)
        val factory = DaggerFactoryComponentMVVM.create().provideVMFactory()
        viewModel = ViewModelProvider(this, factory).get(DaggerViewModelAladhan::class.java)
        progressBar.setVisibility(View.GONE);

        btnSD.setOnClickListener {
            progressBar.setVisibility(View.VISIBLE);
            viewModel.setOnClick(getCityCountry().first,getCityCountry().second)
            viewModel.getLiveData().observe(this, Observer {
                sunRiseD.text=it.Sunrise.toString()
                sunSetD.text=it.Sunset.toString()
                fajrD.text=it.Fajr.toString()
                imsakD.text=it.Imsak.toString()
                dhuhrD.text=it.Dhuhr.toString()
                maghribD.text=it.Maghrib.toString()
                asrD.text=it.Asr.toString()
                ishaD.text=it.Isha.toString()
                midNightD.text=it.Midnight.toString()
                progressBar.setVisibility(View.GONE);
            })


        }

    }

    fun getCityCountry():Pair<String,String>{
        val city=cityD.text.toString()
        val country=countryD.text.toString()
        return city to country
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
