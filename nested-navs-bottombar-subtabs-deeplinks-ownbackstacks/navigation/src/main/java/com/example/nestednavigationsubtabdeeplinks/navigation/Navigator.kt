package com.example.nestednavigationsubtabdeeplinks.navigation

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class Navigator(private val backStack: NavBackStack<NavKey>) {
    fun navigate(key: NavKey) {
        backStack.add(key)
    }

    fun goBack() {
        backStack.removeLastOrNull()
    }

    fun replaceAll(key: NavKey) {
        backStack.clear()
        backStack.add(key)
    }

    fun replaceAll(keys: List<NavKey>) {
        backStack.clear()
        backStack.addAll(keys)
    }
}
