package com.example.schedulekpi.feature_schedule.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.schedulekpi.R
import com.example.schedulekpi.feature_schedule.presentation.search_schedule.SearchScheduleScreen
import com.example.schedulekpi.feature_schedule.presentation.splash.SplashScheduleScreen
import com.example.schedulekpi.feature_schedule.presentation.util.Screen
import com.example.schedulekpi.ui.theme.ScheduleKpiTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScheduleKpiTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.SplashScreen.route
                ) {
                    composable(route = Screen.SplashScreen.route) {
                        SplashScheduleScreen(navController = navController)
                    }
                    composable(route = Screen.SearchScheduleScreen.route) {
                        SearchScheduleScreen(navController = navController)
                    }
                    composable(route = Screen.ScheduleScreen.route) {
                        Text(text = "this is schedule")
                    }
                }
            }
        }
    }
}