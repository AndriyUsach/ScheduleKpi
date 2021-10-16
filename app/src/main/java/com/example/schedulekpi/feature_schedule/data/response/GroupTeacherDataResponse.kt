package com.example.schedulekpi.feature_schedule.data.response

import com.google.gson.annotations.SerializedName

data class GroupTeacherDataResponse(

    @SerializedName("teacher_id")
    val id: String,

    @SerializedName("teacher_name")
    val name: String,

    @SerializedName("teacher_full_name")
    val fullName: String,

    @SerializedName("teacher_short_name")
    val shortName: String,

    @SerializedName("teacher_url")
    val url: String,

    @SerializedName("teacher_rating")
    val rating: String
)