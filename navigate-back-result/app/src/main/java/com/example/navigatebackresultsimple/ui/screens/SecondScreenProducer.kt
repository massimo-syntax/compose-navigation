package com.example.navigatebackresultsimple.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navigatebackresultsimple.DataTypeResult1
import kotlin.random.Random

@Composable
fun SecondScreenProducer(
    onNavigateBack: () -> Unit,
    onSetResult: (DataTypeResult1) -> Unit,
){

    Column(
        Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Start screen")

        Spacer(Modifier.height(24.dp))
        Button(
            // set result
            onClick = {
                // generate some result
                val rndInt = Random.nextInt()
                val result = "New result is $rndInt"
                onSetResult(DataTypeResult1(result))
                onNavigateBack()
            }
        ){
            Text("save result")
        }
    }

}