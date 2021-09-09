package com.example.schedulekpi.data

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["lesson_id", "teacher_id"])
class LessonTeacherCrossRef(
    @ColumnInfo(name = "lesson_id") val lessonId: Int,
    @ColumnInfo(name = "teacher_id") val teacherId: Int
)