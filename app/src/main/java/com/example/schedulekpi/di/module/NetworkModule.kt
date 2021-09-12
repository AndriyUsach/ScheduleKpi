package com.example.schedulekpi.di.module

import com.example.schedulekpi.api.ScheduleApi
import com.example.schedulekpi.api.ScheduleRemoteSource
import com.example.schedulekpi.data.common.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideScheduleApi(retrofit: Retrofit): ScheduleApi {
        return retrofit.create(ScheduleApi::class.java)
    }

    @Provides
    fun provideScheduleRemoteSource(scheduleApi: ScheduleApi): ScheduleRemoteSource {
        return ScheduleRemoteSource(scheduleApi)
    }
}