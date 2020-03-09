package com.example.myapplicationa4.LiveData

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationa4.R
import kotlinx.android.synthetic.main.livedata_activity_test.*

class TestLiveDataActivity : AppCompatActivity() {

    //LiveData baraye save Observe data component hayi ke rooye an livedata emal shode dar soorat har change
    lateinit var viewModel: NewViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.livedata_activity_test)
        viewModel= ViewModelProvider(this).get(NewViewModel::class.java)
        //ijad ertebat live data
        viewModel.getLiveData().observe(this, Observer {
            Toast.makeText(this,it, Toast.LENGTH_LONG).show()
        })
        btnSave1.setOnClickListener(){
            viewModel.setData("Some Data!")
        }

    }
}