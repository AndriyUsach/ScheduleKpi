package com.example.schedulekpi.feature_schedule.presentation.search_schedule

sealed class SearchScheduleEvent {
    data class UpdateSearch(val text: String) : SearchScheduleEvent()
    data class SelectSchedule(val text: String) : SearchScheduleEvent()
}