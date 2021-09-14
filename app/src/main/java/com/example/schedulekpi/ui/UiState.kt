package com.example.schedulekpi.ui

sealed class UiState {

    object SplashState : UiState()
    object ScheduleSelectorState: UiState()
    object MainScreenState: UiState()
}