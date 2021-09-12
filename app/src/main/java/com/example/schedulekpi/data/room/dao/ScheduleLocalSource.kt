package com.example.schedulekpi.data.room.dao

import com.example.schedulekpi.data.room.Lesson
import com.example.schedulekpi.data.room.LessonWithTeachersAndRooms

class ScheduleLocalSource(private val lessonDao: LessonDao) {

    suspend fun getLessons() : List<LessonWithTeachersAndRooms> {
        return lessonDao.getLessons()
    }

    suspend fun addLesson(lesson: Lesson) {
        lessonDao.insert(lesson)
    }

    suspend fun addLesson(vararg lessons: Lesson) {
        lessonDao.insert(*lessons)
    }

    suspend fun addLesson(lessons: List<Lesson>) {
        lessonDao.insert(lessons)
    }

    suspend fun updateLesson(lesson: Lesson) {
        lessonDao.update(lesson)
    }

    suspend fun deleteLesson(lesson: Lesson) {
        lessonDao.delete(lesson)
    }
}