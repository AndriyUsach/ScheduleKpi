package com.example.schedulekpi.di.module

import android.app.Application
import androidx.room.Room
import com.example.schedulekpi.feature_schedule.data.db.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideScheduleDatabase(app: Application): ScheduleDatabase {
        return Room.databaseBuilder(
            app,
            ScheduleDatabase::class.java,
            ScheduleDatabase.DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideLessonDao(
        scheduleDatabase: ScheduleDatabase
    ): LessonDao {
        return scheduleDatabase.lessonDao
    }

    @Provides
    fun provideTeacherDao(
        scheduleDatabase: ScheduleDatabase
    ): TeacherDao {
        return scheduleDatabase.teacherDao
    }

    @Provides
    fun provideRoomDao(
        scheduleDatabase: ScheduleDatabase
    ): RoomDao {
        return scheduleDatabase.roomDao
    }

    @Provides
    fun provideLessonTeacherDao(
        scheduleDatabase: ScheduleDatabase
    ): LessonTeacherDao {
        return scheduleDatabase.lessonTeacherDao
    }

    @Provides
    fun provideLessonRoomDao(
        scheduleDatabase: ScheduleDatabase
    ): LessonRoomDao {
        return scheduleDatabase.lessonRoomDao
    }

    @Provides
    fun provideGroupScheduleDao(
        scheduleDatabase: ScheduleDatabase
    ): GroupScheduleDao {
        return scheduleDatabase.groupScheduleDao
    }
}