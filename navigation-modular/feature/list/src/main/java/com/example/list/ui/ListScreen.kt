package com.example.list.ui

import android.icu.text.LocaleDisplayNames
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ListScreen(
    viewModel: ListViewModel = viewModel()
){
    val data by viewModel.data.collectAsStateWithLifecycle()
    Column(
        Modifier.padding(16.dp)
    ) {
        if(data is UiState.Loading){
            Text("loading")
            return@Column
        }
        val list = (data as UiState.Success).data

        LazyColumn {
            items(items = list, key = {it.hashCode()}){
                Row{
                    Text(
                        "${it.title}",
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }
        }

    }

}