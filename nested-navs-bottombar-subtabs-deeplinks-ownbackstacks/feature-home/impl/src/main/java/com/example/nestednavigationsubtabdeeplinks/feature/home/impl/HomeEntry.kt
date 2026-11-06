package com.example.nestednavigationsubtabdeeplinks.feature.home.impl

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.nestednavigationsubtabdeeplinks.feature.home.api.ScaffoldHomeKey

fun EntryProviderScope<NavKey>.homeEntry(
    onNavigateToDetail: (Int) -> Unit
) {
    entry<ScaffoldHomeKey> {
        val viewModel = hiltViewModel<HomeViewModel>()
        HomeScreen(
            viewModel = viewModel,
            onItemClick = onNavigateToDetail
        )
    }
}
