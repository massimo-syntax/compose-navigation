package com.example.nestednavigationsubtabdeeplinks.feature.profile.impl

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nestednavigationsubtabdeeplinks.feature.profile.api.ProfileSubTab
import kotlinx.coroutines.launch

@Composable
internal fun ProfileScreen(
    initialSubTab: ProfileSubTab
) {
    val subTabs = ProfileSubTab.entries
    val pagerState = rememberPagerState(
        initialPage = initialSubTab.ordinal,
        pageCount = { subTabs.size }
    )
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Profile Screen",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Subtab Segment Selector
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            subTabs.forEachIndexed { index, subTab ->
                FilterChip(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    label = { Text(subTab.name) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                when (subTabs[page]) {
                    ProfileSubTab.ME -> {
                        Text(
                            text = "Me Subtab\nUser Profile Info & Bio",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    ProfileSubTab.SKILLS -> {
                        Text(
                            text = "Skills Subtab\n• Kotlin\n• Jetpack Compose\n• Navigation 3\n• Hilt",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    ProfileSubTab.PROFILE -> {
                        Text(
                            text = "Profile Settings Subtab\nAccount & Preferences",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }
        }
    }
}
