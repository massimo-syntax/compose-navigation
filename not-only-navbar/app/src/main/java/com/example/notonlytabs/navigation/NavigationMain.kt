package com.example.notonlytabs

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.notonlytabs.featue.listDetail.apiNavKeys.ListDetail
import com.example.notonlytabs.featue.listDetail.ui.ListDetailScreen
import com.example.notonlytabs.featue.listDetail.ui.ListDetailViewModel
import com.example.notonlytabs.featue.sharedUiMain.Tabs
import com.example.notonlytabs.featue.sharedUiMain.apiNavKeys.Tabs
import com.example.notonlytabs.navigation.Nav3ViewModel


@Composable
fun NavigationMain(){

    val nav3ViewModel = viewModel<Nav3ViewModel>()
    val mainBackStack = nav3ViewModel.mainBackStack

    NavDisplay(
        backStack = mainBackStack,
        entryDecorators = listOf(
            // with those, a NEW viewmodel is created every time that the entry is composed
            // rememberSaveableStateHolderNavEntryDecorator(),
            // rememberViewModelStoreNavEntryDecorator()
            // without, the viewmodel is the same,
            // in this case is better to find the same state of before again, a random number.
        ),
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
            entry<ListDetail> { key ->
                ListDetailScreen(
                    id = key.id.toInt(),
                    viewModel = viewModel(factory = ListDetailViewModel.Factory(key)),
                    onBack = { mainBackStack.removeLastOrNull() }
                )
            }
        },
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) + fadeIn() togetherWith
                    slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
        },
        popTransitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) + fadeIn() togetherWith
                    slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith slideOutHorizontally(
                targetOffsetX = { it }
            )
        }
    )
}


