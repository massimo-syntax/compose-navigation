package com.example.data.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


private val myData = mutableListOf(
    MyRepositoryModel(0,"title1","description 1",91234567890,false),
    MyRepositoryModel(1,"title2","description 2",41234567890,false),
    MyRepositoryModel(2,"title3","description 3",21234567890,false),
    MyRepositoryModel(3,"title4","description 4",61234567890,false),
    MyRepositoryModel(4,"title5","description 5",81234567890,false),
)

class MyRepositoryImpl : MyRepository {

    override fun observeData(): Flow<List<MyRepositoryModel>> = flow{
        emit(myData)
    }

    override fun loadDataFromId(id: Int): MyRepositoryModel {
        return myData[id]
    }

}