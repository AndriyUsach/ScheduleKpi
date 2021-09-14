package com.example.schedulekpi.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.schedulekpi.data.common.Constants

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = Constants.DATA_STORE_NAME)