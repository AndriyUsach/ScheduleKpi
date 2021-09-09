package com.example.schedulekpi.di.module

import dagger.Module


@Module(includes = [DatabaseModule::class, NetworkModule::class])
class ApplicationModule {
    //this is root module
}