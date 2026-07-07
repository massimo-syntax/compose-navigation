package com.example.notonlytabs

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.notonlytabs.featue.listDetail.apiNavKeys.ListDetail
import com.example.notonlytabs.featue.listDetail.ui.ListDetailScreen
import com.example.notonlytabs.featue.sharedUiMain.Tabs
import com.example.notonlytabs.featue.sharedUiMain.apiNavKeys.Tabs
import com.example.notonlytabs.navigation.Nav3ViewModel


@Composable
fun NavigationMain(){

    val nav3ViewModel = viewModel<Nav3ViewModel>()
    val mainBackStack = nav3ViewModel.mainBackStack
    NavDisplay(
        backStack = mainBackStack,
        onBack = { mainBackStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Tabs> {
                // The Tabs composable now takes a lambda for navigating to detail
                Tabs(
                    goToDetail = { id ->
                        mainBackStack.add(ListDetail(id))
                    }
                )
            }
            entry<ListDetail> { entry ->
                ListDetailScreen(
                    id = entry.id.toInt(),
                    onBack = { mainBackStack.removeLastOrNull() }
                )
            }
        },
        // Global transitions for the main NavDisplay
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) + fadeIn() togetherWith
                    slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
        },
        popTransitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) + fadeIn() togetherWith
                    slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
        }
    )
}


