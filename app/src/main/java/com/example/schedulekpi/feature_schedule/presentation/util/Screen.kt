package com.example.schedulekpi.feature_schedule.presentation.util

import android.annotation.SuppressLint

sealed class Screen(val route: String) {
    @SuppressLint("CustomSplashScreen")
    object SplashScreen: Screen("splash_schedule_screen")
    object SearchScheduleScreen: Screen("search_schedule_screen")
    object ScheduleScreen: Screen("schedule_screen")
}