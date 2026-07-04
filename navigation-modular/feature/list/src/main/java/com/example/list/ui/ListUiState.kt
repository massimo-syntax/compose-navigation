package com.example.list.ui


sealed interface UiState{
    object Loading
    data class Success(val data: List<ModelUi>): UiState
}