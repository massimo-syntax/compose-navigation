package com.example.navigationexamples.ui.navigationScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.navigationexamples.Home
import com.example.navigationexamples.Product
import com.example.navigationexamples.ProductDetail

@Composable
fun OnBackParameter(){
    NavExample()
}


@Composable
fun NavExample() {

    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() }, // optional, user presses back <
        entryProvider = { key ->
            when (key) {
                is Home -> NavEntry(key) {
                    ScreenHome(
                        onNavigateToProduct = { id ->
                           backStack.add(Product(id))
                        }
                    )
                }

                is Product -> NavEntry(key) {
                    ScreenProduct(
                        productId = key.id,
                        onNavigateBack = {backStack.removeLastOrNull()}
                    )
                }

                else -> NavEntry(Unit) { Text("Unknown route") }
            }
        }
    )
}

@Composable
fun ScreenHome(
    onNavigateToProduct: (String)->Unit,
    ){

    Column(
        Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("this is the home screen")
        Spacer(Modifier.height(24.dp))
        Button(onClick = {
            onNavigateToProduct("product_id-123")
        }) {
            Text("Click to navigate")
        }
    }

}

@Composable
fun ScreenProduct(
    productId:String,
    onNavigateBack: () -> Unit
){
    Column(
        Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("this is the product screen $productId")
        Spacer(Modifier.height(24.dp))
        Button(onClick = {
            onNavigateBack()
        }) {
            Text("Navigate back")
        }
    }
}

