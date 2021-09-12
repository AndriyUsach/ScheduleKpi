package com.example.schedulekpi.api.response

import com.google.gson.annotations.SerializedName

data class GroupDataResponse(

    @SerializedName("statusCode")
    val statusCode: Int,

    @SerializedName("timeStamp")
    val timeStamp: Long,

    @SerializedName("message")
    val message: String,

    @SerializedName("debugInfo")
    val debugInfo: String? = null,

    @SerializedName("meta")
    val meta: MetaResponse? = null,

    @SerializedName("data")
    val data: GroupResponse? = null
)