package com.example.notonlytabs.featue.sharedUiMain.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Color Palette Design Scheme
val DarkGreen = Color(0xFF0D3E3A)
val BrightGreen = Color(0xFF3FD371)
val LightPinkBackground = Color(0xFFFFEBF0)
val DarkText = Color(0xFF1E2229)
val SecondaryText = Color(0xFF7D8494)

@Composable
fun ProfileScreen() {

            Column(modifier = Modifier.fillMaxSize()) {
                // 1. Top Section Canvas Banner
                Box(modifier = Modifier.fillMaxWidth().height(260.dp)) {
                    WaveHeaderBackground(modifier = Modifier.fillMaxSize())
                    Box(
                        modifier = Modifier
                            .size(130.dp)
                            .align(Alignment.BottomCenter)
                            .offset(y = (-10).dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(4.dp)
                            .clip(CircleShape)
                    ) {
                        Box(modifier = Modifier.fillMaxSize().background(Color(0xFFE2A082))) {
                            Text("👩‍🎨", modifier = Modifier.align(Alignment.Center), fontSize = 48.sp)
                        }
                    }
                }

                // 2. Profile Badges and Metadata Info
                Column(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(shape = RoundedCornerShape(6.dp), color = BrightGreen) {
                        Text("PRO", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("My Profile", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = DarkText)
                    Text("UX/UI Designer", fontSize = 14.sp, color = SecondaryText)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 3. Social Media Links Handles Group
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("𝕏", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = SecondaryText)
                    Text("📸", fontSize = 18.sp, color = SecondaryText)
                    Text("Bē", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = SecondaryText)
                    Text("in", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = SecondaryText)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Statistics Panel Segment Layout
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                    StatItem(value = "30", label = "followers")
                    Box(modifier = Modifier.width(1.dp).height(28.dp).background(Color(0xFFE0E0E0)))
                    StatItem(value = "61", label = "following")
                    Box(modifier = Modifier.width(1.dp).height(28.dp).background(Color(0xFFE0E0E0)))
                    StatItem(value = "19", label = "shots")
                    Box(modifier = Modifier.width(1.dp).height(28.dp).background(Color(0xFFE0E0E0)))
                    Text("•••", fontSize = 18.sp, color = DarkText, modifier = Modifier.clickable {})
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Portfolio Section Post Card Header
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Text("Daily UI #5 - User Profile", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = DarkText)
                        Row(modifier = Modifier.padding(top = 2.dp)) {
                            Text("My Profile , ", color = BrightGreen, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                            Text("yesterday", color = SecondaryText, fontSize = 12.sp)
                        }
                    }
                    Text("░", fontSize = 20.sp, color = SecondaryText)
                }

                Spacer(modifier = Modifier.height(12.dp))

                // 6. Project Visual Preview and Floating Action Button Area
                Box(modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 24.dp).padding(bottom = 24.dp)) {
                    Box(modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(24.dp)).background(Color(0xFFE3F2FD))) {
                        Box(modifier = Modifier.size(64.dp).align(Alignment.Center).clip(RoundedCornerShape(16.dp)).background(Color.White)) {
                            Text("❖", fontSize = 32.sp, color = Color(0xFF00B0FF), modifier = Modifier.align(Alignment.Center))
                        }
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = BrightGreen),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.align(Alignment.BottomEnd).padding(12.dp)
                    ) {
                        Text("Follow", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
}




// Custom Painter Drawing the layered abstract vectors & base shapes
@Composable
fun WaveHeaderBackground(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height

        // Dark background base layer color fill
        drawRect(color = DarkGreen)

        // Accent Top Organic Red Fluid Path Layer
        val accentPath = Path().apply {
            moveTo(0f, 0f)
            lineTo(width * 0.4f, 0f)
            cubicTo(width * 0.5f, height * 0.2f, width * 0.2f, height * 0.4f, width * 0.6f, height * 0.35f)
            cubicTo(width * 0.9f, height * 0.3f, width * 0.8f, 0f, width, 0f)
            lineTo(width, height * 0.6f)
            cubicTo(width * 0.8f, height * 0.5f, width * 0.7f, height * 0.2f, width * 0.4f, height * 0.3f)
            cubicTo(width * 0.2f, height * 0.35f, 0f, height * 0.2f, 0f, height * 0.2f)
            close()
        }
        drawPath(path = accentPath, color = Color(0xFFC83737))

        // Main Base White Cutout Mask Wave Path Layer
        val whiteWavePath = Path().apply {
            moveTo(0f, height)
            lineTo(0f, height * 0.7f)
            cubicTo(width * 0.25f, height * 0.55f, width * 0.35f, height * 0.85f, width * 0.7f, height * 0.75f)
            cubicTo(width * 0.85f, height * 0.7f, width * 0.95f, height * 0.82f, width, height * 0.85f)
            lineTo(width, height)
            close()
        }
        drawPath(path = whiteWavePath, color = Color.White)
    }
}

// Reusable Numeric Item Parameter Data Blocks
@Composable
fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = DarkText)
        Text(text = label, fontSize = 12.sp, color = SecondaryText)
    }
}


