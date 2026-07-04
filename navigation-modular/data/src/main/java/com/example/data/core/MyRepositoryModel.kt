package com.example.data.core

import java.sql.Timestamp

data class MyRepositoryModel(
    val id: Int,
    val title: String,
    val description: String,
    val timestamp: Long,
    var bookmarked: Boolean
)