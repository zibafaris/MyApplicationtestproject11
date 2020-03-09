package com.example.myapplicationa4.Dependency_Injection

import dagger.Component

@Component(modules = [TestModule::class])
interface ComponentDependency {

    fun provideA() :ClassA
}