package com.example.navigationmodularization

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.api.ListRoute
import com.example.impl.detailRoutes
import com.example.impl.listRoutes

@Composable
fun Nav(){

    val backStack = rememberNavBackStack(ListRoute)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            listRoutes(backStack)
            detailRoutes(backStack)
        }
    )

}



