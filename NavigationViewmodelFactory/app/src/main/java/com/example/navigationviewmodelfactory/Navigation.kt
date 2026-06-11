package com.example.navigationviewmodelfactory

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.navigationviewmodelfactory.presentation.ui.screens.Screen0
import com.example.navigationviewmodelfactory.presentation.ui.screens.Screen1
import com.example.navigationviewmodelfactory.presentation.ui.screens.Screen1ViewModel


data class Route1(val id: String)

data object Route0

@Composable
fun Navigation(){

    val backStack = remember { mutableStateListOf<Any>(Route0) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        // In order to add the `ViewModelStoreNavEntryDecorator` (see comment below for why)
        // we also need to add the default `NavEntryDecorator`s as well. These provide
        // extra information to the entry's content to enable it to display correctly
        // and save its state.
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route0> {
                    Screen0(
                        onNavigate = {backStack.add(Route1("1234"))}
                    )

            }
            entry<Route1> { key ->
                // Note: We need a new ViewModel for every new RouteB instance. Usually
                // we would need to supply a `key` String that is unique to the
                // instance, however, the ViewModelStoreNavEntryDecorator (supplied
                // above) does this for us, using `NavEntry.contentKey` to uniquely
                // identify the viewModel.
                //
                // tl;dr: Make sure you use rememberViewModelStoreNavEntryDecorator()
                // if you want a new ViewModel for each new navigation key instance.
                Screen1(viewModel = viewModel(factory = Screen1ViewModel.Factory(key)))
            }
        }
    )



}