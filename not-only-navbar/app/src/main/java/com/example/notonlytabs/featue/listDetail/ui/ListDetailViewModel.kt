package com.example.notonlytabs.featue.listDetail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notonlytabs.featue.listDetail.apiNavKeys.ListDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random


class ListDetailViewModel(
    val key: ListDetail
) : ViewModel() {

    private val _screenState = MutableStateFlow(0)
    val screenState = _screenState.asStateFlow()

    fun newInt(){
        _screenState.value += Random.nextInt(-10,10)
    }

    class Factory(
        private val key: ListDetail,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ListDetailViewModel(key) as T
        }
    }

}