package com.example.nestednavigationsubtabdeeplinks.feature.login.impl

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun LoginScreen(
    onLoginNormal: () -> Unit,
    onLoginDeepLink: (String) -> Unit
) {
    var customDeepLink by remember { mutableStateOf("deeplink://home/detail/3") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome & Fake Login",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onLoginNormal,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Login Normally")
        }

        Spacer(modifier = Modifier.height(24.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Deep Link Navigation",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Select a preset deep link or enter a custom one:",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedButton(
                    onClick = { onLoginDeepLink("deeplink://home/detail/2") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("deeplink://home/detail/2")
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedButton(
                    onClick = { onLoginDeepLink("deeplink://profile/skills") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("deeplink://profile/skills")
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedButton(
                    onClick = { onLoginDeepLink("deeplink://feed") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("deeplink://feed")
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = customDeepLink,
                    onValueChange = { customDeepLink = it },
                    label = { Text("Custom Deep Link") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { onLoginDeepLink(customDeepLink) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Login & Open Deep Link")
                }
            }
        }
    }
}
