package com.example.schedulekpi.di.module

import com.example.schedulekpi.api.ScheduleRemoteSource
import com.example.schedulekpi.converters.LessonResponseToModelConverter
import com.example.schedulekpi.data.room.dao.ScheduleLocalSource
import com.example.schedulekpi.repository.ScheduleRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@Module(includes = [DatabaseModule::class, NetworkModule::class])
class ApplicationModule {
    //this is root module

    @Provides
    fun provideScheduleRepository(
        scheduleLocalSource: ScheduleLocalSource,
        scheduleRemoteSource: ScheduleRemoteSource,
        dispatcher: CoroutineDispatcher,
        converter: LessonResponseToModelConverter): ScheduleRepository {
        return ScheduleRepository(
            scheduleLocalSource = scheduleLocalSource,
            scheduleRemoteSource = scheduleRemoteSource,
            dispatcher = dispatcher,
            converter = converter
        )
    }

    @Provides
    fun provideDispatcherIO(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    fun provideLessonResponseToModelConverter(): LessonResponseToModelConverter {
        return LessonResponseToModelConverter()
    }
}