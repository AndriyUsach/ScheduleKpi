package com.example.schedulekpi.feature_schedule.domain.util

import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val GROUP_NAME_KEY = stringPreferencesKey("group_name_key")
    val CURRENT_WEEK_KEY = intPreferencesKey("current_week_key")
}