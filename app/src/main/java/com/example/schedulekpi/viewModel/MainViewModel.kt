package com.example.schedulekpi.viewModel

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.schedulekpi.data.common.Constants
import com.example.schedulekpi.ui.UiState
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first

class MainViewModel(
    private val dataStore: DataStore<Preferences>
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.SplashState)
    val uiState: StateFlow<UiState>
        get() = _uiState

    private var scheduleType: String? = null
    private var group: String? = null
    private var teacher: String? = null


    fun setNewUiState(newState: UiState) {
        _uiState.value = newState
    }

    suspend fun saveScheduleInfoFromDataStore(type: String, owner: String) {
        dataStore.edit { settings ->
            settings[Constants.DATA_STORE_SCHEDULE_TYPE] = type
            settings[Constants.DATA_STORE_SCHEDULE_OWNER] = owner
        }
    }

    suspend fun readGroupScheduleInfoFromDataStore(): Pair<String?, String?> {
        val (type, owner) = viewModelScope.async {
            val preferences = dataStore.data.first()
            val type = preferences[Constants.DATA_STORE_SCHEDULE_TYPE]
            val owner = preferences[Constants.DATA_STORE_SCHEDULE_OWNER]
            return@async listOf<String?>(type, owner)
        }.await()
        return Pair(type, owner)
    }
}


class MainViewModelFactory(
    private val dataStore: DataStore<Preferences>
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(dataStore = dataStore) as T
        else
            throw IllegalArgumentException("Unknown view model class")
    }

}