package com.example.navigationviewmodelfactory.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Screen0(
    onNavigate:()->Unit
){
    Column(
        Modifier.padding(16.dp)
    ) {
        Text("Screen0")
        Spacer(Modifier.height(16.dp))
        Button(onClick = onNavigate) {
            Text("Click to navigate")
        }
    }
}