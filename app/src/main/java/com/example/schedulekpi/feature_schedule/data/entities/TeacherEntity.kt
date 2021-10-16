package com.example.schedulekpi.feature_schedule.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TeacherEntity(
    @PrimaryKey @ColumnInfo(name = "teacher_id") val teacherId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "short_name") val shortName: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "rating") val rating: String
)