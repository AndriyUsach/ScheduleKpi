package com.example.schedulekpi.repository

import com.example.schedulekpi.api.ScheduleRemoteSource
import com.example.schedulekpi.converters.LessonResponseToModelConverter
import com.example.schedulekpi.data.room.Lesson
import com.example.schedulekpi.data.room.dao.ScheduleLocalSource
import kotlinx.coroutines.*

class ScheduleRepository(
    private val scheduleRemoteSource: ScheduleRemoteSource,
    private val scheduleLocalSource: ScheduleLocalSource,
    private val converter: LessonResponseToModelConverter,
    dispatcher: CoroutineDispatcher
) {

    private val job: Job? = null

    private val scope = CoroutineScope(dispatcher)

    suspend fun updateSchedule(group: String) {
        if (job?.isActive == true) {
            job.join()
        } else {
            val job = scope.launch {
//                val schedule =
//                    withContext(scope.coroutineContext) {
//                        scheduleRemoteSource.getGroupSchedule(group).data
//                    }
//                if (schedule.isNullOrEmpty())
//                    return@launch
//                val newSchedule = withContext(scope.coroutineContext) {
//                    converter.convert(schedule)
//                }
                val schedule = scheduleRemoteSource.getGroupSchedule(group).data
                if (schedule.isNullOrEmpty())
                    return@launch
                val container = converter.convert(schedule)
                converter.clear()

                scheduleLocalSource.addLesson(container.lessons)
            }
        }
    }

    private suspend fun writeLessonToSchedule(lesson: List<Lesson>) {

    }


}