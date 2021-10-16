package com.example.schedulekpi.feature_schedule.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LessonEntity(

    @PrimaryKey @ColumnInfo(name = "lesson_id") val lessonId: Int,
    @ColumnInfo(name = "week_number") val weekNumber: Int,
    @ColumnInfo(name = "day_number") val dayNumber: Int,
    @ColumnInfo(name = "group_id") val groupId: Int,
    @ColumnInfo(name = "day_name") val dayName: String,
    @ColumnInfo(name = "lesson_name") val lessonName: String,
    @ColumnInfo(name = "lesson_full_name") val lessonFullName: String,
    @ColumnInfo(name = "lesson_number") val lessonNumber: Int,
    @ColumnInfo(name = "lesson_room") val lessonRoom: String,
    @ColumnInfo(name = "lesson_type") val lessonType: String,
    @ColumnInfo(name = "teacher_name") val teacherName: String,
    @ColumnInfo(name = "time_start") val timeStart: String,
    @ColumnInfo(name = "time_end") val timeEnd: String,
    @ColumnInfo(name = "rate") val rate: String,
)