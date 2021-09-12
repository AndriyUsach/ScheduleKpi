package com.example.schedulekpi.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.schedulekpi.data.common.DatabaseInfo
import com.example.schedulekpi.data.room.dao.LessonDao
import com.example.schedulekpi.data.room.dao.RoomDao
import com.example.schedulekpi.data.room.dao.TeacherDao

@Database(entities = [
    Lesson::class,
    Teacher::class,
    Room::class,
    LessonRoomCrossRef::class,
    LessonTeacherCrossRef::class], version = DatabaseInfo.databaseVersion)
abstract class ScheduleDatabase: RoomDatabase() {

    abstract fun lessonDao(): LessonDao
    abstract fun teacherDao(): TeacherDao
    abstract fun roomDao(): RoomDao

}