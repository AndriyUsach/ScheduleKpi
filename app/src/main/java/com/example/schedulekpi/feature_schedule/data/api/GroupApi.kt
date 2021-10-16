package com.example.schedulekpi.feature_schedule.data.api

import com.example.schedulekpi.feature_schedule.data.response.GroupDataResponse
import com.example.schedulekpi.feature_schedule.data.response.GroupScheduleResponse
import com.example.schedulekpi.feature_schedule.data.response.GroupsNameListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GroupApi {

    @GET("groups/{name}")
    suspend fun getGroupByName(
        @Path("name") name: String
    ): GroupDataResponse

    @GET("groups/?")
    suspend fun searchGroupByPrefix(
        @Query("search") search: String
    ): GroupsNameListResponse

    @GET("groups/{group}/lessons")
    suspend fun getGroupSchedule(
        @Path("group") group: String
    ): GroupScheduleResponse
}