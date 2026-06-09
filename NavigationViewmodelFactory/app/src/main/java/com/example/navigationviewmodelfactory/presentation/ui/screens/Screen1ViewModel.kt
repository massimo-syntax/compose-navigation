package com.example.navigationviewmodelfactory.presentation.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Screen1ViewModel : ViewModel(){

    private val _screenState = MutableStateFlow(UiState())
    val screenState: StateFlow<UiState> = _screenState.asStateFlow()


}
data class UiState(
    val data:String = "initial data state"
)