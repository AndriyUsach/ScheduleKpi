package com.example.schedulekpi.feature_schedule.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import okio.IOException

class SchedulePreferencesRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : SchedulePreferencesRepository{
    override suspend fun getGroupName(key: Preferences.Key<String>): Flow<String?> {
        return dataStore.data
            .catch{ exception ->
                if (exception is IOException)
                    emit(emptyPreferences())
                else
                    throw exception
            }.map { preferences ->
                val groupName = preferences[key]
                groupName
            }
    }

    override suspend fun insertGroupName(key: Preferences.Key<String>, groupName: String) {
        dataStore.edit { preferences ->
            preferences[key] = groupName

        }
    }

    override suspend fun getCurrentWeek(key: Preferences.Key<Int>): Flow<Int?> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException)
                    emit(emptyPreferences())
                else
                    throw exception
            }.map { preferences ->
                val currentWeek = preferences[key]
                currentWeek
            }
    }

    override suspend fun insertCurrentWeek(key: Preferences.Key<Int>, currentWeek: Int) {
        dataStore.edit { preferences ->
            preferences[key] = currentWeek
        }
    }
}