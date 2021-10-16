package com.example.schedulekpi.feature_schedule.domain.usecases

data class ScheduleUseCases(
    val searchSchedule: SearchScheduleUseCase,
    val getScheduleGroupName: GetScheduleGroupNameUseCase,
    val getScheduleCurrentWeek: GetScheduleCurrentWeekUseCase,
    val insertScheduleGroupName: InsertScheduleGroupNameUseCase,
    val insertScheduleCurrentWeek: InsertScheduleCurrentWeekUseCase
)