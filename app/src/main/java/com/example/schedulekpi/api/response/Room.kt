package com.example.schedulekpi.api.response

import com.google.gson.annotations.SerializedName

data class Room(

    @SerializedName("room_id")
    val id: String,

    @SerializedName("room_name")
    val name: String,

    @SerializedName("room_latitude")
    val latitude: String,

    @SerializedName("room_longitude")
    val longitude: String
)