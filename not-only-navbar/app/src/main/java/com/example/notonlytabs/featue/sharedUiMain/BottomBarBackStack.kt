package com.example.notonlytabs.featue.sharedUiMain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class BottomBarBackStack<T : Any>(private val startKey: T) {
    val backStack = mutableStateListOf(startKey)

    var selectedKey by mutableStateOf(startKey)
    // the max count of keys is 2 [start][other]
    // the other is just replaced or if start selected again removed
    fun switchTab(key:T){
        backStack.apply {
            if(size > 1){
                if(key == startKey){
                    removeLastOrNull()
                    selectedKey = key
                }
                else{
                    this[1] = key
                    selectedKey = key
                }
            }else{
                if(key != startKey){
                    add(key)
                    selectedKey = key
                }
            }
        }
    }

    fun back(){
        // in this implementation is always start key
        selectedKey = backStack.first()
        backStack.removeLastOrNull()
    }

}