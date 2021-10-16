package com.example.schedulekpi.feature_schedule.presentation.splash

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.schedulekpi.R
import com.example.schedulekpi.feature_schedule.presentation.splash.component.SplashLogoView
import com.example.schedulekpi.feature_schedule.presentation.util.Screen
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
@Composable
fun SplashScheduleScreen(
    navController: NavController,
    viewModel: SplashScheduleViewModel = hiltViewModel()
) {
    Scaffold {
        SplashLogoView(logoId = R.drawable.logo_color)
    }

    LaunchedEffect(key1 = true) {
        viewModel.navigateTo.collect {
            when(it) {
                is Screen.SearchScheduleScreen -> {
                    navController.navigate(Screen.SearchScheduleScreen.route)
                }
                is Screen.ScheduleScreen -> {
                    navController.navigate(it.route)
                }
                else -> Unit
            }
        }
    }
}