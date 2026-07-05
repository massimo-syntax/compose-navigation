package com.example.navigationmodularization

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay



data object Base: NavKey
@Composable
fun Nav(){
    // navigation
    val backStack = rememberNavBackStack(Base)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {

        }
    )
}





