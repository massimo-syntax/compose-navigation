package com.example.nestednavigationsubtabdeeplinks.feature.feed.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.nestednavigationsubtabdeeplinks.feature.feed.api.ScaffoldFeedKey

fun EntryProviderScope<NavKey>.feedEntry() {
    entry<ScaffoldFeedKey> {
        FeedScreen()
    }
}
