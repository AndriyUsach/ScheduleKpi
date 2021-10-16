package com.example.schedulekpi.feature_schedule.domain.repository

import androidx.datastore.preferences.core.Preferences
import com.example.schedulekpi.feature_schedule.domain.model.Group
import com.example.schedulekpi.feature_schedule.domain.model.Lesson

interface GroupScheduleRepository {

    suspend fun searchSchedule(search: String = ""): List<Group>

    suspend fun getSchedule(groupName: String = ""): List<Lesson>?

    suspend fun cleanSchedule()

    suspend fun getScheduleGroupName(key: Preferences.Key<String>): String?

    suspend fun insertScheduleGroupName(key: Preferences.Key<String>, groupName: String)

    suspend fun getScheduleCurrentWeek(key: Preferences.Key<Int>): Int?

    suspend fun insertScheduleCurrentWeek(key: Preferences.Key<Int>, week: Int)

}