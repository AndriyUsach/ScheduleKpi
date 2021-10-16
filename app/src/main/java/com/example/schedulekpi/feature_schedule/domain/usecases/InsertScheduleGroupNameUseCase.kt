package com.example.schedulekpi.feature_schedule.domain.usecases

import com.example.schedulekpi.feature_schedule.domain.repository.GroupScheduleRepository
import com.example.schedulekpi.feature_schedule.domain.util.PreferencesKeys

class InsertScheduleGroupNameUseCase(
    private val repository: GroupScheduleRepository
) {
    suspend operator fun invoke(groupName: String) {
        repository.insertScheduleGroupName(PreferencesKeys.GROUP_NAME_KEY, groupName)
    }
}