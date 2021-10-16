package com.example.schedulekpi.feature_schedule.presentation.search_schedule

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schedulekpi.feature_schedule.domain.model.Group
import com.example.schedulekpi.feature_schedule.domain.usecases.ScheduleUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class SearchScheduleViewModel @Inject constructor(
    private val scheduleUseCases: ScheduleUseCases
) : ViewModel() {

    private val _searchField = mutableStateOf(SearchScheduleFieldState())
    val search: State<SearchScheduleFieldState>
        get() = _searchField

    @ExperimentalCoroutinesApi
    val result = snapshotFlow { search.value }.mapLatest {
        if (it.search)
            searchGroups(it.text)
        else
            emptyList()
    }

    fun onEvent(event: SearchScheduleEvent) {
        when (event) {
            is SearchScheduleEvent.UpdateSearch -> {
                _searchField.value = SearchScheduleFieldState(
                    text = event.text,
                    search = true
                )
            }
            is SearchScheduleEvent.SelectSchedule -> {
                _searchField.value = SearchScheduleFieldState(
                    text = event.text,
                    search = false
                )
            }
        }
    }

    private suspend fun searchGroups(search: String): List<Group> {
        return withContext(viewModelScope.coroutineContext) {
            scheduleUseCases.searchSchedule(search)
        }
    }
}