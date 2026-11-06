package com.example.nestednavigationsubtabdeeplinks.feature.profile.api

import kotlinx.serialization.Serializable

@Serializable
enum class ProfileSubTab(val segment: String) {
    ME("me"),
    SKILLS("skills"),
    PROFILE("profile");

    companion object {
        fun from(segment: String?): ProfileSubTab =
            entries.firstOrNull { it.segment.equals(segment, ignoreCase = true) } ?: ME
    }
}
