package com.example.schedulekpi.feature_schedule.data.repository

import com.example.schedulekpi.feature_schedule.data.response.GroupDataResponse
import com.example.schedulekpi.feature_schedule.data.response.GroupResponse
import com.example.schedulekpi.feature_schedule.data.response.LessonResponse

interface GroupScheduleRemoteDataSource {

    suspend fun getGroupByName(groupName: String): GroupDataResponse?

    suspend fun searchGroupByPrefix(search: String): List<GroupResponse>?

    suspend fun getGroupSchedule(groupName: String): List<LessonResponse>?
}