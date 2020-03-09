package com.example.myapplicationa4.Dependency_Injection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationa4.R

class DependencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dependency)
        /*
        val e=ClassE()
        val d=ClassD(e)
        val c= ClassC()
        val b= ClassB(c,d)
        val a= ClassA(b)
                 */
        //sakht instance Class A ba Dagger2
        val a=DaggerTestComponent.create().provideA()



    }
}