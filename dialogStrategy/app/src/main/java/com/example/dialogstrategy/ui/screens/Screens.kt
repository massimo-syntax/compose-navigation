package com.example.dialogstrategy.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    onNavigateToDialog:()->Unit
){
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Main Screen")
        Button(
            onClick = onNavigateToDialog
        ) {
            Text("Navigate to dialog")
        }
    }
}

@Composable
fun DialogRouteB(
    id:String,
    onBack: ()->Unit
){
    Surface(
        color = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(CornerSize(16.dp)),
        tonalElevation = 4.dp,
        modifier = Modifier
            .wrapContentSize()
            .padding(24.dp)
    ){
        Column(
            Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Dialog id: $id")
            TextButton(
                onClick = onBack
            ) {
                Text("Dismiss")
            }

        }
    }
}

