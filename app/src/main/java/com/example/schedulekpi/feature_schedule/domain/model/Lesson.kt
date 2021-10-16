package com.example.schedulekpi.feature_schedule.domain.model

data class Lesson(
    val id: Int,
    val name: String,
    val fullName: String,
    val type: String,
    val lessonNumber: Int,
    val lessonWeek: Int,
    val dayNumber: Int,
    val dayName: String,
    val timeStart: String,
    val timeEnd: String,
    val lessonRoom: String,
    val teacherName: String,
    val teacher: List<Teacher>,
    val rooms: List<Room>
)