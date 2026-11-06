package com.example.nestednavigationsubtabdeeplinks.feature.profile.api

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class ScaffoldProfileKey(
    val subTab: ProfileSubTab = ProfileSubTab.ME
) : NavKey
