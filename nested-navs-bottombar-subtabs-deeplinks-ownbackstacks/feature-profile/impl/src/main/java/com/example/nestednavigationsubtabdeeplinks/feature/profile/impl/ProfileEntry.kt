package com.example.nestednavigationsubtabdeeplinks.feature.profile.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.nestednavigationsubtabdeeplinks.feature.profile.api.ScaffoldProfileKey

fun EntryProviderScope<NavKey>.profileEntry() {
    entry<ScaffoldProfileKey> { key ->
        ProfileScreen(initialSubTab = key.subTab)
    }
}
