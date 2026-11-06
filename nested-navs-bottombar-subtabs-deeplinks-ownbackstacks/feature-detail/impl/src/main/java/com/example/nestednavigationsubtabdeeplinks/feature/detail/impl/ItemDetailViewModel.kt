package com.example.nestednavigationsubtabdeeplinks.feature.detail.impl

import androidx.lifecycle.ViewModel
import com.example.nestednavigationsubtabdeeplinks.data.HomeItem
import com.example.nestednavigationsubtabdeeplinks.data.HomeRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = ItemDetailViewModel.Factory::class)
class ItemDetailViewModel @AssistedInject constructor(
    @Assisted private val id: Int,
    private val repository: HomeRepository
) : ViewModel() {

    val item: HomeItem? get() = repository.getItemById(id)

    @AssistedFactory
    interface Factory {
        fun create(id: Int): ItemDetailViewModel
    }
}
