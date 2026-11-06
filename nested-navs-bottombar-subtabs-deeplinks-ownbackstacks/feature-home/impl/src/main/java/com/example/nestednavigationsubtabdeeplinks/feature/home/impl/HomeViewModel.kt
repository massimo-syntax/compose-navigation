package com.example.nestednavigationsubtabdeeplinks.feature.home.impl

import androidx.lifecycle.ViewModel
import com.example.nestednavigationsubtabdeeplinks.data.HomeItem
import com.example.nestednavigationsubtabdeeplinks.data.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {
    val items: List<HomeItem> get() = repository.getItems()
}
