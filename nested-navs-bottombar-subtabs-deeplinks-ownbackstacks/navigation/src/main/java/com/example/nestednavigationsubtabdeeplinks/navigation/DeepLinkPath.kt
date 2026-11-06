package com.example.nestednavigationsubtabdeeplinks.navigation

import androidx.navigation3.runtime.NavKey
import com.example.nestednavigationsubtabdeeplinks.feature.detail.api.ItemDetailKey
import java.net.URI

class DeepLinkPath(link: String?) {
    val stack: List<NavKey>

    init {
        val segments = parseSegments(link)
        val rest = segments.drop(1)

        stack = when (segments.firstOrNull()) {
            "home" -> parseHome(rest)
            "feed" -> listOf(MainKey(MainTab.FEED))
            "profile" -> listOf(MainKey(MainTab.PROFILE, subTab = rest.firstOrNull()))
            else -> listOf(MainKey(MainTab.HOME))
        }
    }

    private fun parseHome(rest: List<String>): List<NavKey> {
        val main = MainKey(MainTab.HOME)
        val id = rest.getOrNull(1)?.toIntOrNull()
        return if (rest.firstOrNull() == "detail" && id != null) {
            listOf(main, ItemDetailKey(id))
        } else {
            listOf(main)
        }
    }

    private fun parseSegments(link: String?): List<String> {
        val uri = runCatching { URI(link ?: return emptyList()) }.getOrNull()
            ?: return emptyList()
        if (!uri.scheme.equals("deeplink", ignoreCase = true)) return emptyList()
        val path = uri.path.orEmpty().split("/").filter { it.isNotBlank() }
        return (listOfNotNull(uri.host) + path).map { it.lowercase() }
    }
}
