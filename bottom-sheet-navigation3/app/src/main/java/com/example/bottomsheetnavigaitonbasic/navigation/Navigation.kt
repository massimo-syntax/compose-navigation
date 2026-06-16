package com.example.bottomsheetnavigaitonbasic.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.bottomsheetnavigaitonbasic.navigation.sceneStrategy.BottomSheetSceneStrategy
import com.example.bottomsheetnavigaitonbasic.ui.components.BottomSheetContent
import com.example.bottomsheetnavigaitonbasic.ui.screens.MainScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation(){


    val backStack = rememberNavBackStack(MainRoute)
    val bottomSheetStrategy = remember { BottomSheetSceneStrategy<NavKey>() }

    NavDisplay(
        backStack = backStack,
        sceneStrategies = listOf(bottomSheetStrategy),
        entryProvider = entryProvider {
            mainRouteEntry(backStack)
            bottomSheetEntry{backStack.removeLastOrNull()}
        }
    )

}


@Serializable
data object MainRoute : NavKey
@Serializable
data object BottomSheetRoute : NavKey

private fun EntryProviderScope<NavKey>.mainRouteEntry(backStack: NavBackStack<NavKey>) {
    entry<MainRoute> {
        MainScreen(
            onBottomSheet = {backStack.add(BottomSheetRoute)}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class) // bottom sheet entry, access .bottomSheet of strategy
private fun EntryProviderScope<NavKey>.bottomSheetEntry(back: ()->Unit) {
    entry<BottomSheetRoute>(
        metadata = BottomSheetSceneStrategy.bottomSheet()
    ) {
        BottomSheetContent()
        // the rest is in BottomSheetScene
    }
}