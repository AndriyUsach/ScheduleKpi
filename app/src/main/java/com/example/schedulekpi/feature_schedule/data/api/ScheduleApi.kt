package com.example.schedulekpi.feature_schedule.data.api

interface ScheduleApi : GroupApi {

    companion object {
        const val BASE_URL = "http://api.rozklad.org.ua/v2/"
    }
}