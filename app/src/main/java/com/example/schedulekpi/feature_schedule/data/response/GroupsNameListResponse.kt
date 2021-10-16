package com.example.schedulekpi.feature_schedule.data.response

import com.google.gson.annotations.SerializedName

data class GroupsNameListResponse(

    @SerializedName("statusCode")
    val statusCode: Int,

    @SerializedName("timeStamp")
    val timeStamp: Long,

    @SerializedName("message")
    val message: String,

    @SerializedName("debugInfo")
    val debugInfo: String? = null,

    @SerializedName("data")
    val data: List<GroupResponse>? = null
)