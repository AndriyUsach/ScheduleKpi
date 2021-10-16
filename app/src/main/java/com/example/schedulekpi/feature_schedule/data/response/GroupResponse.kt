package com.example.schedulekpi.feature_schedule.data.response

import com.google.gson.annotations.SerializedName

data class GroupResponse(

    @SerializedName("group_id")
    val id: Int,

    @SerializedName("group_full_name")
    val fullName: String,

    @SerializedName("group_prefix")
    val prefix: String,

    @SerializedName("group_okr")
    val okr: String,

    @SerializedName("group_type")
    val type: String,

    @SerializedName("group_url")
    val url: String
)