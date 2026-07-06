package com.example.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.model.MyModel

@Composable
fun ListScreen(
    onNavigate: (Int)->Unit
){

    val list = listOf(
        MyModel(0,"title1", "description 1"),
        MyModel(1,"title2", "description 2"),
        MyModel(2,"title3", "description 3"),
        MyModel(3,"title4", "description 4"),
        MyModel(4,"title5", "description 5"),
        MyModel(5,"title6", "description 6"),
    )

    Column(
        Modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text("LIST SCREEN")
        LazyColumn {
            items(items = list, key = {it.hashCode()}){
                Row(
                    Modifier.clickable{ onNavigate(it.id) }
                ) {
                    Text("id: ${it.id}")
                    Text("Title: ${it.title}")
                }
            }
        }
    }
}