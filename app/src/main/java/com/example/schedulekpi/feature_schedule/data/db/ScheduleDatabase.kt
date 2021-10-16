package com.example.schedulekpi.feature_schedule.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.schedulekpi.feature_schedule.data.entities.LessonEntity
import com.example.schedulekpi.feature_schedule.data.entities.RoomEntity
import com.example.schedulekpi.feature_schedule.data.entities.TeacherEntity
import com.example.schedulekpi.feature_schedule.data.relations.LessonRoomCrossRef
import com.example.schedulekpi.feature_schedule.data.relations.LessonTeacherCrossRef

@Database(
    entities = [
        LessonEntity::class,
        RoomEntity::class,
        TeacherEntity::class,
        LessonRoomCrossRef::class,
        LessonTeacherCrossRef::class
    ],
    version = ScheduleDatabase.DB_VERSION
)
abstract class ScheduleDatabase : RoomDatabase() {

    abstract val lessonDao: LessonDao
    abstract val teacherDao: TeacherDao
    abstract val roomDao: RoomDao
    abstract val lessonTeacherDao: LessonTeacherDao
    abstract val lessonRoomDao: LessonRoomDao
    abstract val groupScheduleDao: GroupScheduleDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "schedule_db"
    }
}