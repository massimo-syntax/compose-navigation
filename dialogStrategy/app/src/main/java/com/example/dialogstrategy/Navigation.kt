package com.example.dialogstrategy

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.window.DialogProperties
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.scene.DialogSceneStrategy
import androidx.navigation3.scene.SceneStrategy
import androidx.navigation3.ui.NavDisplay
import com.example.dialogstrategy.ui.screens.DialogRouteB
import com.example.dialogstrategy.ui.screens.MainScreen
import kotlinx.serialization.Serializable

@Serializable
private data object RouteA : NavKey

@Serializable
private data class RouteB(val id: String) : NavKey

@Composable
fun Navigation(){

    val backStack = rememberNavBackStack(RouteA)
    val dialogStrategy = remember { DialogSceneStrategy<NavKey>() }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        sceneStrategies = listOf(dialogStrategy),
        entryProvider = entryProvider {
            entry<RouteA> {
                MainScreen(
                    onNavigateToDialog = {
                        backStack.add(RouteB("route_b_id"))
                    }
                )
            }
            entry<RouteB>(
                metadata = DialogSceneStrategy.dialog(
                    DialogProperties(windowTitle = "Route B dialog")
                )
            ) { key ->
                DialogRouteB(
                    id = key.id,
                    onBack = {backStack.removeLastOrNull()}
                )
            }
        }
    )

}