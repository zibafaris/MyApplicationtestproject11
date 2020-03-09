package com.example.myapplicationa4.LiveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewViewModel : ViewModel() {
    //tarif livedata
    //anvaye livedata: 1. MutableLiveData(simplest livedata) 2.Transformations.Map(if you are loading a data from a repository)
    private val data= MutableLiveData<String?>()
    fun setData(s:String){
        data.value=s
    }
    //chon farzand az parent MutableLiveData ast mitavanad LiveData beshavad
    fun getLiveData() : LiveData<String?> = data
}