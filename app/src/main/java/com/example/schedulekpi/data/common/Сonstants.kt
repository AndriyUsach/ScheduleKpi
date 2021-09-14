package com.example.schedulekpi.data.common

import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {
    const val BASE_URL = "http://api.rozklad.org.ua/v2/"
    const val DATA_STORE_NAME = "schedule_settings"
    val DATA_STORE_SCHEDULE_TYPE = stringPreferencesKey("data_store_schedule_type")
    val DATA_STORE_SCHEDULE_OWNER = stringPreferencesKey("data_store_schedule_owner")
}