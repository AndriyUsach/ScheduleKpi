package com.example.schedulekpi.feature_schedule.data.repository

import android.util.Log
import com.example.schedulekpi.feature_schedule.data.api.GroupApi
import com.example.schedulekpi.feature_schedule.data.response.GroupDataResponse
import com.example.schedulekpi.feature_schedule.data.response.GroupResponse
import com.example.schedulekpi.feature_schedule.data.response.LessonResponse

class GroupScheduleRemoteDataSourceImpl(
    private val groupApi: GroupApi
) : GroupScheduleRemoteDataSource {

    override suspend fun getGroupByName(groupName: String): GroupDataResponse? {
        return try {
            groupApi.getGroupByName(groupName)
        } catch (e: Exception) {
            Log.e("API ERROR", e.message ?: "ERROR GROUP API: getGroupByName ")
            null
        }
    }

    override suspend fun searchGroupByPrefix(search: String): List<GroupResponse>? {
        try {
            val response = groupApi.searchGroupByPrefix(search)
            println(response)

            if (!checkStatusCode(response.statusCode, "searchGroupByPrefix"))
                return emptyList()

            return response.data
        } catch (e: Exception) {
            Log.e("API ERROR", e.message ?: "ERROR GROUP API: searchGroupByPrefix ")
            return null
        }
    }

    override suspend fun getGroupSchedule(groupName: String): List<LessonResponse>? {
        try {
            val response = groupApi.getGroupSchedule(groupName)

            if (!checkStatusCode(response.statusCode, "getGroupSchedule"))
                return emptyList()

            return response.data
        } catch (e: Exception) {
            Log.e("API ERROR", e.message ?: "ERROR GROUP API: getGroupSchedule ")
            return null
        }
    }

    private fun checkStatusCode(statusCode: Int, method: String): Boolean {
        if (statusCode > 210) {
            Log.e(
                "Request Error",
                "GroupApi.$method -> Status Code: $statusCode"
            )
            return false
        }
        return true
    }
}