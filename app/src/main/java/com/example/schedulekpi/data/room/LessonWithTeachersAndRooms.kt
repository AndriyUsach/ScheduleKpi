package com.example.schedulekpi.data.room

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class LessonWithTeachersAndRooms(
    @Embedded val lessons: Lesson,
    @Relation(
        parentColumn = "lesson_id",
        entityColumn = "teacher_id",
        associateBy = Junction(LessonTeacherCrossRef::class)
    )
    val teachers: List<Teacher>,

    @Relation(
        parentColumn = "lesson_id",
        entityColumn = "room_id",
        associateBy = Junction(LessonRoomCrossRef::class)
    )
    val rooms: List<Room>
)