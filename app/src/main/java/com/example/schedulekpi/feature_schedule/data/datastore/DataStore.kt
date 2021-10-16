package com.example.schedulekpi.feature_schedule.data.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

private const val DATA_STORE_NAME = "schedulekpi_settings"

val Context.dataStore by preferencesDataStore(
    name = DATA_STORE_NAME
)