package com.example.nestednavigationsubtabdeeplinks.feature.login.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.nestednavigationsubtabdeeplinks.feature.login.api.LoginKey

fun EntryProviderScope<NavKey>.loginEntry(
    onLoginNormal: () -> Unit,
    onLoginDeepLink: (String) -> Unit
) {
    entry<LoginKey> {
        LoginScreen(
            onLoginNormal = onLoginNormal,
            onLoginDeepLink = onLoginDeepLink
        )
    }
}
