package com.example.notonlytabs.featue.sharedUiMain.apiNavKeys

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// Extend NavKey for serialization and rememberNavBackStack
interface TopLevelRoute : NavKey {
    val icon: String
}
@Serializable
data object Home : TopLevelRoute {
    override val icon = "#"
}

@Serializable
data object ListScreen : TopLevelRoute {
    override val icon = "="
}
@Serializable
data object Profile : TopLevelRoute {
    override val icon = "0"
}

val TOP_LEVEL_ROUTES: List<TopLevelRoute> = listOf(Home, ListScreen, Profile)

@Serializable
data object Tabs : NavKey // Represents the whole scaffold with navbar
