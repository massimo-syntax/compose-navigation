package com.example.nestednavigationsubtabdeeplinks.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RssFeed
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.nestednavigationsubtabdeeplinks.feature.detail.api.ItemDetailKey
import com.example.nestednavigationsubtabdeeplinks.feature.feed.api.ScaffoldFeedKey
import com.example.nestednavigationsubtabdeeplinks.feature.feed.impl.feedEntry
import com.example.nestednavigationsubtabdeeplinks.feature.home.api.ScaffoldHomeKey
import com.example.nestednavigationsubtabdeeplinks.feature.home.impl.homeEntry
import com.example.nestednavigationsubtabdeeplinks.feature.profile.api.ProfileSubTab
import com.example.nestednavigationsubtabdeeplinks.feature.profile.api.ScaffoldProfileKey
import com.example.nestednavigationsubtabdeeplinks.feature.profile.impl.profileEntry

private val tabs = listOf(MainTab.HOME, MainTab.FEED, MainTab.PROFILE)

@Composable
fun MainScaffold(
    initialTab: MainTab,
    initialSubTab: String?,
    appNavigator: Navigator
) {
    val tabStack = rememberNavBackStack(initialTab.toKey(initialSubTab))
    val currentKey = tabStack.last()
    val currentTab = currentKey.toTab()

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEach { tab ->
                    NavigationBarItem(
                        selected = currentTab == tab,
                        onClick = {
                            if (currentTab != tab) {
                                tabStack.clear()
                                tabStack.add(tab.toKey(null))
                            }
                        },
                        icon = {
                            val icon = when (tab) {
                                MainTab.HOME -> Icons.Default.Home
                                MainTab.FEED -> Icons.Default.RssFeed
                                MainTab.PROFILE -> Icons.Default.Person
                            }
                            Icon(icon, contentDescription = tab.name)
                        },
                        label = { Text(tab.name) }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavDisplay(
            modifier = Modifier.padding(paddingValues),
            backStack = tabStack,
            onBack = { /* Single entry tab stack, fall back to outer */ },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = entryProvider {
                homeEntry(
                    onNavigateToDetail = { id ->
                        appNavigator.navigate(ItemDetailKey(id))
                    }
                )
                feedEntry()
                profileEntry()
            }
        )
    }
}

private fun MainTab.toKey(subTab: String?): NavKey = when (this) {
    MainTab.HOME -> ScaffoldHomeKey
    MainTab.FEED -> ScaffoldFeedKey
    MainTab.PROFILE -> ScaffoldProfileKey(ProfileSubTab.from(subTab))
}

private fun NavKey.toTab(): MainTab = when (this) {
    is ScaffoldFeedKey -> MainTab.FEED
    is ScaffoldProfileKey -> MainTab.PROFILE
    else -> MainTab.HOME
}
