package com.example.schedulekpi.feature_schedule.domain.usecases

import com.example.schedulekpi.feature_schedule.domain.repository.GroupScheduleRepository
import com.example.schedulekpi.feature_schedule.domain.util.PreferencesKeys

class GetScheduleGroupNameUseCase(
    private val repository: GroupScheduleRepository
) {
    suspend operator fun invoke(): String? {
        return repository.getScheduleGroupName(PreferencesKeys.GROUP_NAME_KEY)
    }
}