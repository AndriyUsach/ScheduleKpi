package com.example.schedulekpi.converters


import com.example.schedulekpi.api.response.LessonResponse
import com.example.schedulekpi.data.common.Container
import com.example.schedulekpi.data.room.Lesson
import com.example.schedulekpi.data.room.Room
import com.example.schedulekpi.data.room.Teacher

class LessonResponseToModelConverter {

    private val lessons =  mutableListOf<Lesson>()
    private val teachers = mutableListOf<Teacher>()
    private val rooms = mutableListOf<Room>()

    suspend fun convert(response: List<LessonResponse>): Container {

        response.forEach {
            val newLesson = Lesson(
                weekNumber = it.lessonWeek.toInt(),
                dayNumber = it.dayNumber.toInt(),
                lessonId = it.lessonId.toInt(),
                groupId = it.groupId.toInt(),
                dayName = it.dayName,
                lessonName = it.lessonName,
                lessonFullName = it.lessonFullName,
                lessonNumber = it.lessonNumber.toInt(),
                lessonRoom = it.lessonRoom,
                lessonType = it.lessonType,
                teacher_name = it.teacherName,
                timeStart = it.timeStart,
                timeEnd = it.timeEnd,
                rate = it.rate
            )
            lessons.add(newLesson)

            if (!it.teachers.isNullOrEmpty()) {
                val teachers = it.teachers
                teachers.forEach { teacher ->
                    val newTeacher = Teacher(
                        teacherId = teacher.id.toInt(),
                        name = teacher.name,
                        fullName = teacher.fullName,
                        shortName = teacher.shortName,
                        url = teacher.url,
                        rating = teacher.rating
                    )
                    this.teachers.add(newTeacher)
                }
            }

            if (!it.rooms.isNullOrEmpty()) {
                val rooms = it.rooms
                rooms.forEach { room ->
                    val newRoom = Room(
                        id = room.id.toInt(),
                        name = room.name,
                        latitude = room.latitude,
                        longitude = room.longitude
                    )

                    this.rooms.add(newRoom)
                }
            }
        }

        return Container(
            lessons = lessons,
            teachers = teachers,
            rooms = rooms
        )
    }

    suspend fun clear() {
        lessons.clear()
        teachers.clear()
        rooms.clear()
    }
}