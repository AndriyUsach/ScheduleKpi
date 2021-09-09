package com.example.schedulekpi.di.component

import com.example.schedulekpi.MainActivity
import com.example.schedulekpi.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
}