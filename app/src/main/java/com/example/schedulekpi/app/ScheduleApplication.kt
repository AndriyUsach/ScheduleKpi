package com.example.schedulekpi.app

import android.app.Application
import com.example.schedulekpi.di.component.ApplicationComponent
import com.example.schedulekpi.di.component.DaggerApplicationComponent

class ScheduleApplication: Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    companion object {
        lateinit var instance: ScheduleApplication
    }
}