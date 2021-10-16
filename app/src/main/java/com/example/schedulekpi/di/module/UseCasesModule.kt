package com.example.schedulekpi.di.module

import com.example.schedulekpi.feature_schedule.domain.repository.GroupScheduleRepository
import com.example.schedulekpi.feature_schedule.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    fun provideSearchScheduleUseCase(
        repository: GroupScheduleRepository
    ): SearchScheduleUseCase {
        return SearchScheduleUseCase(repository)
    }

    @Provides
    fun provideGetScheduleGroupNameUseCase(
        repository: GroupScheduleRepository
    ): GetScheduleGroupNameUseCase {
        return GetScheduleGroupNameUseCase(repository)
    }

    @Provides
    fun provideGetScheduleCurrentWeekUseCase(
        repository: GroupScheduleRepository
    ): GetScheduleCurrentWeekUseCase {
        return GetScheduleCurrentWeekUseCase(repository)
    }

    @Provides
    fun provideInsertScheduleGroupNameUseCase(
        repository: GroupScheduleRepository
    ): InsertScheduleGroupNameUseCase {
        return InsertScheduleGroupNameUseCase(repository)
    }

    @Provides
    fun provideInsertScheduleCurrentWeekUseCase(
        repository: GroupScheduleRepository
    ): InsertScheduleCurrentWeekUseCase {
        return InsertScheduleCurrentWeekUseCase(repository)
    }

    @Provides
    fun provideScheduleUseCases(
        searchScheduleUseCase: SearchScheduleUseCase,
        getScheduleGroupNameUseCase: GetScheduleGroupNameUseCase,
        getScheduleCurrentWeekUseCase: GetScheduleCurrentWeekUseCase,
        insertScheduleGroupNameUseCase: InsertScheduleGroupNameUseCase,
        insertScheduleCurrentWeekUseCase: InsertScheduleCurrentWeekUseCase
    ): ScheduleUseCases {
        return ScheduleUseCases(
            searchSchedule = searchScheduleUseCase,
            getScheduleGroupName = getScheduleGroupNameUseCase,
            getScheduleCurrentWeek = getScheduleCurrentWeekUseCase,
            insertScheduleGroupName = insertScheduleGroupNameUseCase,
            insertScheduleCurrentWeek = insertScheduleCurrentWeekUseCase
        )
    }
}