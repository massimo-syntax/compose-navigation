package com.example.impl

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.api.DetailRoute
import com.example.ui.DetailScreen

@Composable

fun EntryProviderScope<NavKey>.detailRoutes(backStack: NavBackStack<NavKey>) {
    entry<DetailRoute>{ key ->
        DetailScreen(key.id) { backStack.removeLastOrNull() }
    }
}