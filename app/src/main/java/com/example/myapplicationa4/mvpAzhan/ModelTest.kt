package com.example.myapplicationa4.mvpAzhan


import com.example.myapplicationa4.retrofit.azhanInterface
import com.example.myapplicationa4.retrofit.jsonClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    class ModelTest(private val presenter: Contract.Presenter) {

    fun getPrayTimeData(country: String, city: String){
        val retrofit= Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val adhanInterface= retrofit.create(azhanInterface::class.java)

        adhanInterface.getTimings(city,country,8)
            .enqueue(object: Callback<jsonClass>{
                override fun onFailure(call: Call<jsonClass>, t: Throwable) {
                    presenter.onRetrofitResponse(false,null)
                }

                override fun onResponse(call: Call<jsonClass>, response: Response<jsonClass>) {
                    val result= response.body()?.data?.timings
                    presenter.onRetrofitResponse(true,result)
                }

            })
    }

}
