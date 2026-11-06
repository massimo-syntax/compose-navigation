package com.example.nestednavigationsubtabdeeplinks.feature.detail.impl

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.nestednavigationsubtabdeeplinks.feature.detail.api.ItemDetailKey

fun EntryProviderScope<NavKey>.itemDetailEntry(
    onBack: () -> Unit
) {
    entry<ItemDetailKey> { key ->
        val viewModel = hiltViewModel<ItemDetailViewModel, ItemDetailViewModel.Factory>(
            creationCallback = { factory -> factory.create(key.id) }
        )
        ItemDetailScreen(
            viewModel = viewModel,
            onBack = onBack
        )
    }
}
