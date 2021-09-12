package com.example.schedulekpi.di.component

import android.app.Application
import com.example.schedulekpi.di.module.ApplicationModule
import com.example.schedulekpi.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(application: Application)
}