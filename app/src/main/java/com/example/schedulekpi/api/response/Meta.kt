package com.example.schedulekpi.api.response

import com.google.gson.annotations.SerializedName

data class Meta(

    @SerializedName("total_count")
    val totalCount: String,

    @SerializedName("offset")
    val offset: Int,

    @SerializedName("limit")
    val limit: Int
)