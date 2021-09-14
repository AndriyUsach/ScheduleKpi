package com.example.schedulekpi.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.schedulekpi.app.ScheduleApplication
import com.example.schedulekpi.data.common.Constants
import com.example.schedulekpi.ui.UiState
import com.example.schedulekpi.ui.screen.SplashScreen
import com.example.schedulekpi.ui.theme.ScheduleKpiTheme
import com.example.schedulekpi.utils.dataStore
import com.example.schedulekpi.viewModel.MainViewModel
import com.example.schedulekpi.viewModel.MainViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by lazy {
        MainViewModelFactory(this.dataStore).create(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScheduleApplication.instance.applicationComponent.inject(this)


        lifecycleScope.launchWhenStarted {
            delay(3000)
            val scheduleInfo = mainViewModel.readGroupScheduleInfoFromDataStore()
            val uiState = selectNextUiState(scheduleInfo)
            mainViewModel.setNewUiState(uiState)
        }

        setContent {
            ScheduleKpiTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
                    mainViewModel.uiState.collectAsState().value.let { uiState ->
                        when(uiState) {
                            is UiState.SplashState -> SplashScreen()
                            is UiState.ScheduleSelectorState -> {
                                Text(text = "This is ScheduleSelectorState")
                            }
                            is UiState.MainScreenState -> {
                                Text(text = "Hello Android")
                            }
                            else -> finish()
                        }
                    }
                }
            }
        }
    }
    
    private fun selectNextUiState(scheduleInfo: Pair<String?, String?>): UiState {
        if (scheduleInfo.first.isNullOrEmpty() || scheduleInfo.second.isNullOrEmpty())
            return UiState.ScheduleSelectorState
        return UiState.MainScreenState
    }
}