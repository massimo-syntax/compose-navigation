package com.example.navigationviewmodelfactory.presentation.ui.screens.screen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.navigationviewmodelfactory.Route1

@Composable
fun Screen1(
    viewModel: Screen1ViewModel = viewModel(),
    onNavigateBack: ()->Unit
) {

    val screenState by viewModel.screenState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Screen 1 , ${viewModel.key}")
        Text(screenState.data)
        Button(onClick = onNavigateBack){
            Text("navigate back")
        }
    }
}