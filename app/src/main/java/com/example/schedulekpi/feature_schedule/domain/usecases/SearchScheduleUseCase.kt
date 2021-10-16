package com.example.schedulekpi.feature_schedule.domain.usecases

import com.example.schedulekpi.feature_schedule.domain.model.Group
import com.example.schedulekpi.feature_schedule.domain.repository.GroupScheduleRepository

class SearchScheduleUseCase(
    private val repository: GroupScheduleRepository
) {

    suspend operator fun invoke(search: String): List<Group> {
        return repository.searchSchedule(search)
    }
}