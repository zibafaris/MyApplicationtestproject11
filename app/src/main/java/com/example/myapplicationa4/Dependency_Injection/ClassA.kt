package com.example.myapplicationa4.Dependency_Injection

import retrofit2.Retrofit
import javax.inject.Inject

class ClassA @Inject constructor(b:ClassB, retrofit: Retrofit) {
}