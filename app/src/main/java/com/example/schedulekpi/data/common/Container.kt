package com.example.schedulekpi.data.common

import com.example.schedulekpi.data.room.Lesson
import com.example.schedulekpi.data.room.Room
import com.example.schedulekpi.data.room.Teacher

data class Container(
    val lessons: List<Lesson>,
    val teachers: List<Teacher>,
    val rooms: List<Room>
)