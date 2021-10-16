package com.example.schedulekpi.feature_schedule.domain.usecases

import com.example.schedulekpi.feature_schedule.domain.repository.GroupScheduleRepository
import com.example.schedulekpi.feature_schedule.domain.util.PreferencesKeys

class GetScheduleCurrentWeekUseCase(
    private val repository: GroupScheduleRepository
) {
    suspend operator fun invoke(): Int? {
        return repository.getScheduleCurrentWeek(PreferencesKeys.CURRENT_WEEK_KEY)
    }
}