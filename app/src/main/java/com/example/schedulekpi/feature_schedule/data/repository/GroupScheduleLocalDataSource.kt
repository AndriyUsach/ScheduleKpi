package com.example.schedulekpi.feature_schedule.data.repository

import com.example.schedulekpi.feature_schedule.data.response.LessonResponse
import com.example.schedulekpi.feature_schedule.domain.model.Lesson

interface GroupScheduleLocalDataSource {

    suspend fun getSchedule(): List<Lesson>
    suspend fun saveSchedule(lessons: List<LessonResponse>)
    suspend fun clearSchedule()
}