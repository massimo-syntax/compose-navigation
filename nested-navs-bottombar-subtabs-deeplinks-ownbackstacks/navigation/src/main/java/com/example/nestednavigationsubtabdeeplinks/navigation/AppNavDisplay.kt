package com.example.nestednavigationsubtabdeeplinks.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.nestednavigationsubtabdeeplinks.feature.detail.impl.itemDetailEntry
import com.example.nestednavigationsubtabdeeplinks.feature.login.api.LoginKey
import com.example.nestednavigationsubtabdeeplinks.feature.login.impl.loginEntry

@Composable
fun AppNavDisplay(
    modifier: Modifier = Modifier,
    initialLink: String? = null
) {
    val backStack = rememberNavBackStack(LoginKey as NavKey)
    val navigator = remember(backStack) { Navigator(backStack) }

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = navigator::goBack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            loginEntry(
                onLoginNormal = {
                    if (!initialLink.isNullOrBlank()) {
                        val deepLinkStack = DeepLinkPath(initialLink).stack
                        navigator.replaceAll(deepLinkStack)
                    } else {
                        navigator.replaceAll(MainKey(MainTab.HOME))
                    }
                },
                onLoginDeepLink = { link ->
                    val deepLinkStack = DeepLinkPath(link).stack
                    navigator.replaceAll(deepLinkStack)
                }
            )
            itemDetailEntry(
                onBack = navigator::goBack
            )
            entry<MainKey> { mainKey ->
                MainScaffold(
                    initialTab = mainKey.tab,
                    initialSubTab = mainKey.subTab,
                    appNavigator = navigator
                )
            }
        }
    )
}
