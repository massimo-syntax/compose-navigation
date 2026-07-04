package com.example.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.core.MyRepositoryImpl
import com.example.data.core.MyRepositoryModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    val repository  = MyRepositoryImpl()

    val data = repository
        .observeData()
        .map {
            UiState.Success(it.toUiModel())
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UiState.Loading,
        )
    // or also collect{_data.value = it}



}

private fun List<MyRepositoryModel>.toUiModel() : List<ModelUi> = map{ it.toUiModel() }
private fun MyRepositoryModel.toUiModel() : ModelUi =
    ModelUi(id,title,timestamp,bookmarked)
