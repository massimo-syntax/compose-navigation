package com.example.notonlytabs.featue.listDetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun ListDetailScreen(
    id: Int,
    onBack: ()->Unit
){
    var number by remember { mutableIntStateOf(0) }

    Column(
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Detail id: $id")

        Text(number.toString())
        Button( onClick = { number+= Random.nextInt(-10,10) } ) {
            Text("+", fontSize = 24.sp)
        }

        Button(onClick = onBack) {
            Text("Go Back")
        }
    }


}