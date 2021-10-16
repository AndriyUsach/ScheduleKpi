package com.example.schedulekpi.feature_schedule.data.repository

import androidx.datastore.preferences.core.Preferences
import com.example.schedulekpi.feature_schedule.data.mappers.GroupMapper
import com.example.schedulekpi.feature_schedule.data.mappers.LessonMapper
import com.example.schedulekpi.feature_schedule.domain.model.Group
import com.example.schedulekpi.feature_schedule.domain.model.Lesson
import com.example.schedulekpi.feature_schedule.domain.repository.GroupScheduleRepository
import com.example.schedulekpi.feature_schedule.domain.util.UrlHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class GroupScheduleRepositoryImpl(
    private val localDataSource: GroupScheduleLocalDataSource,
    private val remoteDataSource: GroupScheduleRemoteDataSource,
    private val preferencesDataSource: SchedulePreferencesRepository
) : GroupScheduleRepository {
    override suspend fun searchSchedule(search: String): List<Group> {
        if (search.isEmpty() || search.length < 2)
            return emptyList()
        val groups = remoteDataSource.searchGroupByPrefix(UrlHelper.makeSearchParameter(search))
            ?: return emptyList()
        return groups.map { GroupMapper.toGroup(it) }
    }

    override suspend fun getSchedule(groupName: String): List<Lesson>? {
        if (groupName.isNotEmpty())
            return localDataSource.getSchedule()
        val lessonResponses = remoteDataSource.getGroupSchedule(groupName = groupName)
            ?: return null

        CoroutineScope(coroutineContext).launch {
            localDataSource.saveSchedule(lessonResponses)
        }
        return lessonResponses.map { LessonMapper.toLesson(it) }
    }


    override suspend fun cleanSchedule() {
        localDataSource.clearSchedule()
    }

    override suspend fun getScheduleGroupName(key: Preferences.Key<String>): String? {
        return preferencesDataSource.getGroupName(key).first()
    }

    override suspend fun insertScheduleGroupName(key: Preferences.Key<String>, groupName: String) {
        preferencesDataSource.insertGroupName(key, groupName)
    }

    override suspend fun getScheduleCurrentWeek(key: Preferences.Key<Int>): Int? {
        return preferencesDataSource.getCurrentWeek(key).first()
    }

    override suspend fun insertScheduleCurrentWeek(key: Preferences.Key<Int>, week: Int) {
        return preferencesDataSource.insertCurrentWeek(key, week)
    }
}