package com.example.navigationviewmodelfactory.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Screen1(
    modifier: Modifier = Modifier,
    viewModel: Screen1ViewModel = viewModel()
){

    val screenState by viewModel.screenState.collectAsStateWithLifecycle()
    Column(
        modifier.fillMaxSize()
    ) {

        Text(screenState.data)

    }

}