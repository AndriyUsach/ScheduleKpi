package com.example.schedulekpi.feature_schedule.presentation.splash

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schedulekpi.feature_schedule.domain.usecases.ScheduleUseCases
import com.example.schedulekpi.feature_schedule.presentation.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScheduleViewModel @Inject constructor(
    private val scheduleUseCases: ScheduleUseCases
) : ViewModel() {

    private val _navigateTo = mutableStateOf<Screen>(Screen.SplashScreen)

    val navigateTo = snapshotFlow { _navigateTo.value }

    init {
        selectNextScreen()
    }

    private fun selectNextScreen() {
        viewModelScope.launch {
            val group = scheduleUseCases.getScheduleGroupName()
            if (group.isNullOrEmpty()) {
                _navigateTo.value = Screen.SearchScheduleScreen
            }
            else
                _navigateTo.value = Screen.ScheduleScreen
        }
    }
}