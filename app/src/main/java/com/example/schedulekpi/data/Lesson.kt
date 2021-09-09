package com.example.schedulekpi.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Lesson(
    @PrimaryKey val id: Int,
    //field for select the desired lessons
    @ColumnInfo(name = "week_number") val weekNumber: Int,
    @ColumnInfo(name = "day_number") val dayNumber: Int,
    //--------------------------------------------------
    @ColumnInfo(name = "lesson_id") val lessonId: Int,
    @ColumnInfo(name = "group_id") val groupId: Int,
    @ColumnInfo(name = "day_name") val dayName: String,
    @ColumnInfo(name = "lesson_name") val lessonName: String,
    @ColumnInfo(name = "lesson_full_name") val lessonFullName: String,
    @ColumnInfo(name = "lesson_number") val lessonNumber: Int,
    @ColumnInfo(name = "lesson_room") val lessonRoom: String,
    @ColumnInfo(name = "lesson_type") val lessonType: String,
    @ColumnInfo(name = "teacher_name") val teacher_name: String,
    @ColumnInfo(name = "time_start") val timeStart: String,
    @ColumnInfo(name = "time_end") val timeEnd: String,
    @ColumnInfo(name = "rate") val rate: String,
)