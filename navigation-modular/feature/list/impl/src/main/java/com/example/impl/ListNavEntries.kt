package com.example.impl

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.api.DetailRoute
import com.example.api.ListRoute
import com.example.ui.ListScreen


@Composable
fun EntryProviderScope<NavKey>.listRoutes(backStack: NavBackStack<NavKey>) {
    entry<ListRoute>{
        ListScreen(
            onNavigate = { id -> backStack.add(DetailRoute(id)) }
        )
    }
}