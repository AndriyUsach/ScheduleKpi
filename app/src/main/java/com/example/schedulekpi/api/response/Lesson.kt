package com.example.schedulekpi.api.response

import com.google.gson.annotations.SerializedName

data class Lesson(

    @SerializedName("lesson_id")
    val lessonId: String,

    @SerializedName("group_id")
    val groupId: String,

    @SerializedName("day_number")
    val dayNumber: String,

    @SerializedName("day_name")
    val dayName: String,

    @SerializedName("lesson_name")
    val lessonName: String,

    @SerializedName("lesson_full_name")
    val lessonFullName: String,

    @SerializedName("lesson_number")
    val lessonNumber: String,

    @SerializedName("lesson_room")
    val lessonRoom: String,

    @SerializedName("lesson_type")
    val lessonType: String,

    @SerializedName("teacher_name")
    val teacherName: String,

    @SerializedName("lesson_week")
    val lessonWeek: String,

    @SerializedName("time_start")
    val timeStart: String,

    @SerializedName("time_end")
    val timeEnd: String,

    @SerializedName("rate")
    val rate: String,

    @SerializedName("teachers")
    val teachers: List<GroupTeacher>,

    @SerializedName("rooms")
    val rooms: List<Room>
)
