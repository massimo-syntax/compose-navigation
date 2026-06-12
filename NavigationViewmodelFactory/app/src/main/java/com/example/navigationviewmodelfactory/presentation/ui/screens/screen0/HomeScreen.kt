package com.example.navigationviewmodelfactory.presentation.ui.screens.screen0

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    onNavigate:(String)->Unit,
    viewModel: HomeScreenViewModel = viewModel()
){
    val list = viewModel.finalList
    Column(
        Modifier.padding(16.dp)
    ) {
        Text("Home Screen, no key from viewmodel")
        Spacer(Modifier.height(16.dp))

        LazyColumn{
            items(list){
                Row {
                    Text(it)
                    Button(onClick = { onNavigate(it) } ) {
                        Text("Click to navigate")
                    }
                }
                Spacer(Modifier.height(8.dp))
            }

        }


    }
}

