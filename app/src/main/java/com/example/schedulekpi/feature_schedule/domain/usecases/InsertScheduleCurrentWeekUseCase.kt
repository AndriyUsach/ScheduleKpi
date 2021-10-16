package com.example.schedulekpi.feature_schedule.domain.usecases

import com.example.schedulekpi.feature_schedule.domain.repository.GroupScheduleRepository
import com.example.schedulekpi.feature_schedule.domain.util.PreferencesKeys

class InsertScheduleCurrentWeekUseCase(
    private val repository: GroupScheduleRepository
) {
    suspend operator fun invoke(week: Int) {
        repository.insertScheduleCurrentWeek(PreferencesKeys.CURRENT_WEEK_KEY, week)
    }
}