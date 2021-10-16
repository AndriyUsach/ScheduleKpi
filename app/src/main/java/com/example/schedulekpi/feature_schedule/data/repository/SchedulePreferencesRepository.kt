package com.example.schedulekpi.feature_schedule.data.repository

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface SchedulePreferencesRepository {

    suspend fun getGroupName(key: Preferences.Key<String>): Flow<String?>

    suspend fun insertGroupName(key: Preferences.Key<String>, groupName: String)

    suspend fun getCurrentWeek(key: Preferences.Key<Int>): Flow<Int?>

    suspend fun insertCurrentWeek(key: Preferences.Key<Int>, currentWeek: Int)
}