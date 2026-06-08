package com.example.navigationexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.navigationexamples.ui.navigationScreens.EntryProvider
import com.example.navigationexamples.ui.navigationScreens.EntryProviderDsl
import com.example.navigationexamples.ui.navigationScreens.OnBackParameter
import com.example.navigationexamples.ui.theme.NavigationExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationExamplesTheme {
               /* Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationLandingMain(innerPadding)
                }
                */
                //EntryProvider()
                //EntryProviderDsl()
                OnBackParameter()
            }
        }
    }
}

// format code : ctrl + alt + shift + l