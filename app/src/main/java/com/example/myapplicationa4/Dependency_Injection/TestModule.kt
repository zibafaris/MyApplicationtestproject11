package com.example.myapplicationa4.Dependency_Injection

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class TestModule {
    @Provides
    fun retrofitProvider(): Retrofit = Retrofit.Builder().build()

}