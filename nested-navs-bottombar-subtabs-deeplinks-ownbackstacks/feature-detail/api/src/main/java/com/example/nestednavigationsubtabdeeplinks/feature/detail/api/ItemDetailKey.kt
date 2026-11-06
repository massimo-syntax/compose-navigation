package com.example.nestednavigationsubtabdeeplinks.feature.detail.api

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class ItemDetailKey(val id: Int) : NavKey
