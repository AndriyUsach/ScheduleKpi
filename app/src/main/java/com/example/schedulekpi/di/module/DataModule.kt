package com.example.schedulekpi.di.module

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.schedulekpi.feature_schedule.data.api.GroupApi
import com.example.schedulekpi.feature_schedule.data.datastore.dataStore
import com.example.schedulekpi.feature_schedule.data.db.*
import com.example.schedulekpi.feature_schedule.data.repository.*
import com.example.schedulekpi.feature_schedule.domain.repository.GroupScheduleRepository
import com.example.schedulekpi.feature_schedule.domain.usecases.ScheduleUseCases
import com.example.schedulekpi.feature_schedule.domain.usecases.SearchScheduleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDataStore(
        app: Application
    ): DataStore<Preferences> {
        return app.dataStore
    }

    @Provides
    fun provideSchedulePreferencesRepository(
        dataStore: DataStore<Preferences>
    ): SchedulePreferencesRepository {
        return SchedulePreferencesRepositoryImpl(dataStore)
    }

    @Provides
    fun provideGroupScheduleLocalDataSource(
        lessonDao: LessonDao,
        teacherDao: TeacherDao,
        roomDao: RoomDao,
        lessonRoomDao: LessonRoomDao,
        lessonTeacherDao: LessonTeacherDao,
        groupScheduleDao: GroupScheduleDao
    ): GroupScheduleLocalDataSource {
        return GroupScheduleLocalDataSourceImpl(
            lessonDao = lessonDao,
            teacherDao = teacherDao,
            roomDao = roomDao,
            lessonRoomDao = lessonRoomDao,
            lessonTeacherDao = lessonTeacherDao,
            groupScheduleDao = groupScheduleDao
        )
    }

    @Provides
    fun provideGroupScheduleRemoteDataSource(
        groupApi: GroupApi
    ): GroupScheduleRemoteDataSource {
        return GroupScheduleRemoteDataSourceImpl(groupApi = groupApi)
    }

    @Provides
    fun provideGroupScheduleRepository(
        localDataSource: GroupScheduleLocalDataSource,
        remoteDataSource: GroupScheduleRemoteDataSource,
        preferencesDataSource: SchedulePreferencesRepository
    ): GroupScheduleRepository {
        return GroupScheduleRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource,
            preferencesDataSource = preferencesDataSource
        )
    }
}