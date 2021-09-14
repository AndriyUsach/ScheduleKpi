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
import com.example.schedulekpi.ui.UiState
import com.example.schedulekpi.ui.screen.SplashScreen
import com.example.schedulekpi.ui.theme.ScheduleKpiTheme
import com.example.schedulekpi.viewModel.MainViewModel
import com.example.schedulekpi.viewModel.MainViewModelFactory
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    private val uiStateViewModel: MainViewModel by lazy {
        MainViewModelFactory().create(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScheduleApplication.instance.applicationComponent.inject(this)

        lifecycleScope.launchWhenStarted {
            delay(3000)
            uiStateViewModel.setNewUiState(UiState.MainScreenState)
        }

        setContent {
            ScheduleKpiTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
                    uiStateViewModel.uiState.collectAsState().value.let { uiState ->
                        when(uiState) {
                            is UiState.SplashState -> SplashScreen()
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
}