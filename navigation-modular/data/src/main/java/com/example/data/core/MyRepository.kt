package com.example.data.core

import kotlinx.coroutines.flow.Flow

interface MyRepository {
    fun observeData(): Flow<List<MyRepositoryModel>>
    fun loadDataFromId(id:Int): MyRepositoryModel
}