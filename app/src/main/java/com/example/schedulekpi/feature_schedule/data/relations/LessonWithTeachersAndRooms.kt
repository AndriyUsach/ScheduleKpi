package com.example.schedulekpi.feature_schedule.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.schedulekpi.feature_schedule.data.entities.LessonEntity
import com.example.schedulekpi.feature_schedule.data.entities.RoomEntity
import com.example.schedulekpi.feature_schedule.data.entities.TeacherEntity

data class LessonWithTeachersAndRooms(
    @Embedded val lesson: LessonEntity,
    @Relation(
        parentColumn = "lesson_id",
        entityColumn = "teacher_id",
        associateBy = Junction(LessonTeacherCrossRef::class)
    )
    val teachers: List<TeacherEntity>,

    @Relation(
        parentColumn = "lesson_id",
        entityColumn = "room_id",
        associateBy = Junction(LessonRoomCrossRef::class)
    )
    val rooms: List<RoomEntity>
)