package com.example.schedulekpi.data.room.dao

import com.example.schedulekpi.data.room.Lesson
import com.example.schedulekpi.data.room.LessonWithTeachersAndRooms
import com.example.schedulekpi.data.room.Room
import com.example.schedulekpi.data.room.Teacher

class ScheduleLocalSource(
    private val lessonDao: LessonDao,
    private val teacherDao: TeacherDao,
    private val roomDao: RoomDao) {

    //Lesson methods

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

    //Teacher methods

    suspend fun addTeacher(teacher: Teacher) {
        teacherDao.insert(teacher)
    }

    suspend fun addTeacher(vararg teachers: Teacher) {
        teacherDao.insert(*teachers)
    }

    suspend fun addTeacher(teachers: List<Teacher>) {
        teacherDao.insert(teachers)
    }

    suspend fun updateTeacher(teacher: Teacher) {
        teacherDao.update(teacher)
    }

    suspend fun deleteTeacher(teacher: Teacher) {
        teacherDao.delete(teacher)
    }

    //Room methods

    suspend fun addRoom(room: Room) {
        roomDao.insert(room)
    }

    suspend fun addRoom(vararg rooms: Room) {
        roomDao.insert(*rooms)
    }

    suspend fun addRoom(rooms: List<Room>) {
        roomDao.insert(rooms)
    }

    suspend fun updateRoom(room: Room) {
        roomDao.update(room)
    }

    suspend fun deleteRoom(room: Room) {
        roomDao.delete(room)
    }
}