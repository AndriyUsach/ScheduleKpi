package com.example.schedulekpi.feature_schedule.data.relations

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.*

@Entity(primaryKeys = ["lesson_id", "teacher_id"])
data class LessonTeacherCrossRef(
    @ColumnInfo(name = "lesson_id") val lessonId: Int,
    @ColumnInfo(name = "teacher_id") val teacherId: Int
)