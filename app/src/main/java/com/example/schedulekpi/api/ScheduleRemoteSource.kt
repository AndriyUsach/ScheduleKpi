package com.example.schedulekpi.api

import com.example.schedulekpi.api.response.GroupListResponse
import com.example.schedulekpi.api.response.GroupDataResponse
import com.example.schedulekpi.api.response.GroupScheduleResponse
import com.example.schedulekpi.api.response.GroupTeacherResponse
import com.example.schedulekpi.utils.UrlHelper

class ScheduleRemoteSource(
    private val scheduleApi: ScheduleApi
) {
    suspend fun getGroups(): GroupListResponse {
        return scheduleApi.getGroups()
    }

    suspend fun getGroupByName(name: String): GroupDataResponse {
        return scheduleApi.getGroupByName(name)
    }

    suspend fun getGroupById(id: Int): GroupDataResponse {
        return scheduleApi.getGroupById(id.toString())
    }

    suspend fun searchGroupByPrefix(prefix: String): GroupListResponse {
        return scheduleApi.searchGroupByPrefix(UrlHelper.makeSearchParameter(prefix))
    }

    suspend fun getGroupSchedule(group: String): GroupScheduleResponse {
        return scheduleApi.getGroupSchedule(group)
    }

    suspend fun getGroupTeachers(group: String): GroupTeacherResponse {
        return scheduleApi.getGroupTeachers(group)
    }
}