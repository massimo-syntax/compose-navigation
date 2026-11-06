package com.example.nestednavigationsubtabdeeplinks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nestednavigationsubtabdeeplinks.navigation.AppNavDisplay
import com.example.nestednavigationsubtabdeeplinks.ui.theme.NestedNavigationSubtabDeeplinksTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val initialLink = intent?.data?.toString()
        setContent {
            NestedNavigationSubtabDeeplinksTheme {
                AppNavDisplay(initialLink = initialLink)
            }
        }
    }
}
