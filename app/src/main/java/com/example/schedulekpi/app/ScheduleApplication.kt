package com.example.schedulekpi.app

import android.app.Application
import com.example.schedulekpi.di.component.ApplicationComponent
import com.example.schedulekpi.di.component.DaggerApplicationComponent
import com.example.schedulekpi.di.module.DatabaseModule

class ScheduleApplication: Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .databaseModule(DatabaseModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    companion object {
        lateinit var instance: ScheduleApplication
    }
}