package com.example.schedulekpi.feature_schedule.data.response

import com.google.gson.annotations.SerializedName

data class RoomResponse(

    @SerializedName("room_id")
    val id: String,

    @SerializedName("room_name")
    val name: String,

    @SerializedName("room_latitude")
    val latitude: String,

    @SerializedName("room_longitude")
    val longitude: String
)