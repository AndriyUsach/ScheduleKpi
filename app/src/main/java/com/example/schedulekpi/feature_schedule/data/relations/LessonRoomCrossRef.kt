package com.example.schedulekpi.feature_schedule.data.relations

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(primaryKeys = ["lesson_id", "room_id"])
data class LessonRoomCrossRef(
    @ColumnInfo(name = "lesson_id") val lessonId: Int,
    @ColumnInfo(name = "room_id") val roomId: Int
)