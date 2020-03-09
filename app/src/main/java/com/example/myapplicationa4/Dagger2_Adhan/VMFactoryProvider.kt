package com.example.myapplicationa4.Dagger2_Adhan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class VMFactoryProvider @Inject constructor(val model: DaggerModelAladhan) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(DaggerViewModelAladhan::class.java) ->
                return DaggerViewModelAladhan(model) as T

            else -> throw IllegalArgumentException("ViewModel Is not provided")
        }
    }
}