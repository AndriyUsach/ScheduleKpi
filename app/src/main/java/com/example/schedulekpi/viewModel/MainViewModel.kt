package com.example.schedulekpi.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.schedulekpi.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.IllegalArgumentException

class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.SplashState)
    val uiState: StateFlow<UiState>
        get() = _uiState


    fun setNewUiState(newState: UiState) {
        _uiState.value = newState
    }
}


class MainViewModelFactory(): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel() as T
        else
            throw IllegalArgumentException("Unknown view model class")
    }

}