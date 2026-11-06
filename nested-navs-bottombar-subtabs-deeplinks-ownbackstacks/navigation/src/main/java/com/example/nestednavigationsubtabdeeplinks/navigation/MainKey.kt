package com.example.nestednavigationsubtabdeeplinks.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class MainKey(
    val tab: MainTab = MainTab.HOME,
    val subTab: String? = null
) : NavKey
