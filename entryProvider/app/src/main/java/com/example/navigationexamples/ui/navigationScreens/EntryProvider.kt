package com.example.navigationexamples.ui.navigationScreens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.navigationexamples.ProductDetail
import com.example.navigationexamples.ProductList


@Composable
fun EntryProvider() {

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Nav Entry Provider Screen", color = Color.Red, style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(24.dp))
        MyNavDisplay()
    }

}

@Composable
private fun MyNavDisplay(){

    val backStack = remember { mutableStateListOf<Any>(ProductList) }

    NavDisplay(
        backStack = backStack,
        entryProvider = { key ->
            when (key) {
                is ProductList -> NavEntry(key) {
                    ProductList(
                        onListItemSelected = { id ->
                            backStack.add(ProductDetail(id = id))
                        }
                    )
                }
                is ProductDetail -> NavEntry(
                    key,
                    metadata = mapOf("extraDataKey" to "extraDataValue")
                ) {
                    ProductDetails(
                        productId = key.id,
                        onBackPressed = {backStack.removeLastOrNull()}
                    )
                }

                else -> {
                    NavEntry(Unit) { Text(text = "Invalid Key: $it") }
                }
            }
        }
    )


}

@Composable
private fun ProductDetails(
    productId: String,
    onBackPressed: ()->Unit
){
    Column {
        Text("product details of product $productId")
        Button(
            onClick = onBackPressed
        ) {
            Text("Back")
        }
    }
}

@Composable
private fun ProductList(
    onListItemSelected : (String)->Unit
){
    Column(
        Modifier.border(1.dp, Color.DarkGray)
    ) {

        Button(
            onClick = {
                onListItemSelected("p_1")
            }
        ) {
            Text("product 1")
        }
        Button(
            onClick = {
                onListItemSelected("p_2")
            }
        ) {
            Text("product 2")
        }
        Button(
            onClick = {
                onListItemSelected("p_3")
            }
        ) {
            Text("product 3")
        }
    }
}