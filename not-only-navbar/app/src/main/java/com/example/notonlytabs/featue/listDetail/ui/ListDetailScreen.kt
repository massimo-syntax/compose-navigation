package com.example.notonlytabs.featue.listDetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun ListDetailScreen(
    id: Int,
    viewModel: ListDetailViewModel,
    onBack: ()->Unit
){
    val number by viewModel.screenState.collectAsStateWithLifecycle()

    Column(
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Detail id: $id")
        Text("or, key from viewmodel: ${viewModel.key}")

        Text(number.toString())
        Button( onClick = { viewModel.newInt() } ) {
            Text("+", fontSize = 24.sp)
        }

        Button(onClick = onBack) {
            Text("Go Back")
        }
    }


}