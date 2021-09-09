package com.example.schedulekpi.di.module

import com.example.schedulekpi.api.ScheduleApi
import com.example.schedulekpi.data.common.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideScheduleApi(retrofit: Retrofit): ScheduleApi {
        return retrofit.create(ScheduleApi::class.java)
    }
}