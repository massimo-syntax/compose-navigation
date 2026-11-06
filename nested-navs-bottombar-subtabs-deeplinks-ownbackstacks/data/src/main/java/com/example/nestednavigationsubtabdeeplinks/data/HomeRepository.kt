package com.example.nestednavigationsubtabdeeplinks.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor() {
    private val items = listOf(
        HomeItem(1, "Navigation 3 Overview", "Learn about Navigation 3 architecture and multi-module setup.", "Architecture"),
        HomeItem(2, "Compose Multi-module", "Structuring feature modules cleanly with api and impl submodules.", "Modularization"),
        HomeItem(3, "Deep Links & Backstacks", "Parsing URIs into Navigation 3 backstacks with nested scaffolds.", "Deep Linking"),
        HomeItem(4, "Hilt Assisted Injection", "Passing arguments to ViewModels in Navigation 3 using AssistedInject.", "Dependency Injection"),
        HomeItem(5, "Subtabs & Pager", "Implementing segmented subtabs inside a feature using HorizontalPager.", "UI Patterns")
    )

    fun getItems(): List<HomeItem> = items

    fun getItemById(id: Int): HomeItem? = items.find { it.id == id }
}
