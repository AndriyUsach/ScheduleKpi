package com.example.schedulekpi.api

import com.example.schedulekpi.api.response.GroupListResponse
import com.example.schedulekpi.api.response.GroupDataResponse
import com.example.schedulekpi.api.response.GroupTeacherResponse
import com.example.schedulekpi.api.response.GroupScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ScheduleApi : GroupApi, TeacherApi, InfoApi


interface GroupApi {

    //sine=SD
    //get first 100 groups
    @GET("groups")
    suspend fun getGroups(): GroupListResponse

    //get group by name
    @GET("groups/{name}")
    suspend fun getGroupByName(
        @Path("name") name: String
    ): GroupDataResponse

    //get group by id
    @GET("groups/{id}")
    suspend fun getGroupById(
        @Path("id") id: String
    ): GroupDataResponse

    // search group by prefix
    @GET("groups/?")
    suspend fun searchGroupByPrefix(
        @Query("search") search: String
    ): GroupListResponse

    @GET("groups/{group}/lessons")
    suspend fun getGroupSchedule(
        @Path("group") group: String
    ): GroupScheduleResponse

    @GET("groups/{group}/teachers")
    suspend fun getGroupTeachers(
        @Path("group") group: String
    ): GroupTeacherResponse

}


interface TeacherApi {

}

interface InfoApi {

}