package com.example.schedulekpi.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Teacher(
    @PrimaryKey @ColumnInfo(name = "teacher_id") val teacherId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "short_name") val shortName: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "rating") val rating: String
)