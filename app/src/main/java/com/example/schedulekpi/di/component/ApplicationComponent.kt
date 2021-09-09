package com.example.schedulekpi.di.component

import com.example.schedulekpi.MainActivity
import com.example.schedulekpi.di.module.ApplicationModule
import dagger.Component


@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
}