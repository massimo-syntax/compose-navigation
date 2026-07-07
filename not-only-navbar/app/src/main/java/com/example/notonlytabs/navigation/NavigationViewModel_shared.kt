package com.example.notonlytabs.navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavKey
import com.example.notonlytabs.featue.sharedUiMain.BottomBarBackStack
import com.example.notonlytabs.featue.sharedUiMain.apiNavKeys.Home
import com.example.notonlytabs.featue.sharedUiMain.apiNavKeys.Tabs
import com.example.notonlytabs.featue.sharedUiMain.apiNavKeys.TopLevelRoute


// In Nav3ViewModel
class Nav3ViewModel : ViewModel() {
    // This back stack manages the overall navigation, including Tabs and global details
    val mainBackStack = mutableStateListOf<NavKey>(Tabs) // Start with the Tabs screen

    // This remains for managing the internal state of the bottom bar tabs
    val bottomBarBackStack = mutableStateOf(BottomBarBackStack<TopLevelRoute>(Home))
}