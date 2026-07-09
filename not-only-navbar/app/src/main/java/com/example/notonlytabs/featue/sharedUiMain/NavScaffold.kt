package com.example.notonlytabs.featue.sharedUiMain

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.notonlytabs.featue.sharedUiMain.apiNavKeys.Home
import com.example.notonlytabs.featue.sharedUiMain.apiNavKeys.ListScreen
import com.example.notonlytabs.featue.sharedUiMain.apiNavKeys.Profile
import com.example.notonlytabs.featue.sharedUiMain.apiNavKeys.TOP_LEVEL_ROUTES
import com.example.notonlytabs.featue.sharedUiMain.ui.ProfileScreen
import com.example.notonlytabs.navigation.Nav3ViewModel


@Composable
fun Tabs(
    goToDetail: ((String) -> Unit)? = null // Lambda to navigate to global detail
) {
    val nav3ViewModel = viewModel<Nav3ViewModel>()
    val topLevelBackStack by nav3ViewModel.bottomBarBackStack

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            NavigationBar {
                TOP_LEVEL_ROUTES.forEach { topLevelRoute ->
                    val isSelected = topLevelRoute == topLevelBackStack.selectedKey
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            topLevelBackStack.switchTab(topLevelRoute)
                        },
                        icon = {
                            Text(topLevelRoute.icon)
                        }
                    )
                }
            }
        }
    ) { contentPadding ->
        NavDisplay(
            backStack = topLevelBackStack.backStack, // This is the tab's internal back stack
            onBack = { topLevelBackStack.back() },
            entryProvider = entryProvider {
                entry<Home> {
                    Text("Home screen")
                }
                entry<ListScreen> {
                    Column {
                        Text("list screen")
                        Button(onClick = { goToDetail?.invoke("1") }) {
                            Text("go to Detail")
                        }
                    }
                }
                entry<Profile> {
                    ProfileScreen()
                }
                // Important: ListDetail is in the main NavDisplay
            },
            modifier = Modifier
                .padding(contentPadding)
                .consumeWindowInsets(WindowInsets.statusBars)
        )
    }
}