package com.example.schedulekpi.di.module

import com.example.schedulekpi.feature_schedule.data.api.GroupApi
import com.example.schedulekpi.feature_schedule.data.api.ScheduleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ScheduleApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideScheduleApi(
        retrofit: Retrofit
    ): ScheduleApi {
        return retrofit.create(ScheduleApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGroupApi(
        scheduleApi: ScheduleApi
    ): GroupApi {
        return scheduleApi
    }
}