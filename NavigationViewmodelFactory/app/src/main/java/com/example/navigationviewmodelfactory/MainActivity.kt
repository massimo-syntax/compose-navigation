package com.example.navigationviewmodelfactory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.navigationviewmodelfactory.presentation.ui.theme.NavigationViewmodelFactoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationViewmodelFactoryTheme {
               Navigation()
            }
        }
    }
}

