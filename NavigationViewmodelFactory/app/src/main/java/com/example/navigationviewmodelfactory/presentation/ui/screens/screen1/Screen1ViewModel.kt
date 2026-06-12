package com.example.navigationviewmodelfactory.presentation.ui.screens.screen1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.navigationviewmodelfactory.Route1
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Screen1ViewModel(
    val key: Route1
) : ViewModel() {

    private val _screenState = MutableStateFlow(UiState())
    val screenState: StateFlow<UiState> = _screenState.asStateFlow()

    class Factory(
        private val key: Route1,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return Screen1ViewModel(key) as T
        }
    }

}



data class UiState(
    val data: String = "initial data state"
)