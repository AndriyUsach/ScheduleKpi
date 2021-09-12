package com.example.schedulekpi.di.module

import android.app.Application
import androidx.room.Room
import com.example.schedulekpi.data.common.DatabaseInfo
import com.example.schedulekpi.data.room.ScheduleDatabase
import com.example.schedulekpi.data.room.dao.LessonDao
import com.example.schedulekpi.data.room.dao.RoomDao
import com.example.schedulekpi.data.room.dao.ScheduleLocalSource
import com.example.schedulekpi.data.room.dao.TeacherDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideScheduleDatabase(): ScheduleDatabase {
        return Room.databaseBuilder(
            application,
            ScheduleDatabase::class.java,
            DatabaseInfo.databaseName,
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideLessonDao(scheduleDatabase: ScheduleDatabase): LessonDao {
        return scheduleDatabase.lessonDao()
    }

    @Provides
    fun provideTeacherDao(scheduleDatabase: ScheduleDatabase): TeacherDao {
        return scheduleDatabase.teacherDao()
    }

    @Provides
    fun provideRoomDao(scheduleDatabase: ScheduleDatabase): RoomDao {
        return scheduleDatabase.roomDao()
    }

    @Provides
    fun provideScheduleLocalSource(
        lessonDao: LessonDao,
        teacherDao: TeacherDao,
        roomDao: RoomDao
    ): ScheduleLocalSource {
        return ScheduleLocalSource(
            lessonDao = lessonDao,
            teacherDao = teacherDao,
            roomDao = roomDao
        )
    }
}