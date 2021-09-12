package com.example.schedulekpi.repository

import android.util.Log
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

    private var job: Job? = null

    private val scope = CoroutineScope(dispatcher)

    suspend fun updateSchedule(group: String) {
        Log.d("ROOM", "START")
        if (job?.isActive == true) {
            job?.join()
        } else {
            job = scope.launch {
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
                println(schedule)
                if (schedule.isNullOrEmpty())
                    return@launch
                val container = converter.convert(schedule)
                println(container)

                Log.d("ROOM", "insert to database")
                println(container.lessons)
                scheduleLocalSource.addLesson(container.lessons)
                scheduleLocalSource.addTeacher(container.teachers)
                scheduleLocalSource.addRoom(container.rooms)
                Log.d("ROOM", "FINISH")
                converter.clear()
            }
        }
    }

    private suspend fun writeLessonToSchedule(lesson: List<Lesson>) {

    }
}