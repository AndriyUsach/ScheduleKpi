package com.example.schedulekpi.feature_schedule.data.mappers

import com.example.schedulekpi.feature_schedule.data.entities.LessonEntity
import com.example.schedulekpi.feature_schedule.data.relations.LessonWithTeachersAndRooms
import com.example.schedulekpi.feature_schedule.data.response.LessonResponse
import com.example.schedulekpi.feature_schedule.domain.model.Lesson

object LessonMapper {

    fun toLesson(response: LessonResponse): Lesson {
        val teachers = response.teachers.map { TeacherMapper.toTeacher(it) }
        val rooms = response.rooms.map { RoomMapper.toRoom(it) }
        return Lesson(
            id = response.lessonId.toInt(),
            name = response.lessonName,
            fullName = response.lessonFullName,
            type = response.lessonType,
            lessonNumber = response.lessonNumber.toInt(),
            lessonWeek = response.lessonWeek.toInt(),
            dayNumber = response.dayNumber.toInt(),
            dayName = response.dayName,
            timeStart = response.timeStart,
            timeEnd = response.timeEnd,
            lessonRoom = response.lessonRoom,
            teacherName = response.teacherName,
            teacher = teachers,
            rooms = rooms
        )
    }

    fun toLesson(entity: LessonWithTeachersAndRooms): Lesson {
        val teachers = entity.teachers.map { TeacherMapper.toTeacher(it) }
        val rooms = entity.rooms.map { RoomMapper.toRoom(it) }
        return Lesson(
            id = entity.lesson.lessonId,
            name = entity.lesson.lessonName,
            fullName = entity.lesson.lessonFullName,
            type = entity.lesson.lessonType,
            lessonNumber = entity.lesson.lessonNumber,
            lessonWeek = entity.lesson.weekNumber,
            dayNumber = entity.lesson.dayNumber,
            dayName = entity.lesson.dayName,
            timeStart = entity.lesson.timeStart,
            timeEnd = entity.lesson.timeEnd,
            lessonRoom = entity.lesson.lessonRoom,
            teacherName = entity.lesson.teacherName,
            teacher = teachers,
            rooms = rooms
        )
    }

    fun toLessonEntity(response: LessonResponse): LessonEntity {
        return LessonEntity(
            lessonId = response.lessonId.toInt(),
            weekNumber = response.lessonWeek.toInt(),
            dayNumber = response.dayNumber.toInt(),
            groupId = response.groupId.toInt(),
            dayName = response.dayName,
            lessonName = response.lessonName,
            lessonFullName = response.lessonFullName,
            lessonNumber = response.lessonNumber.toInt(),
            lessonRoom = response.lessonRoom,
            lessonType = response.lessonType,
            teacherName = response.teacherName,
            timeStart = response.timeStart,
            timeEnd = response.timeEnd,
            rate = response.rate
        )
    }
}