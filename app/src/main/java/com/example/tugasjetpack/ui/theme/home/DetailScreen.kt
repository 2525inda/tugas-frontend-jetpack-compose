package com.example.tugasjetpack.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(foodImage: Int, title: String, description: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            // Display the image
            val imagePainter: Painter = painterResource(id = foodImage)
            Image(painter = imagePainter, contentDescription = title, modifier = Modifier.size(200.dp))

            // Display the title
            Text(text = title, modifier = Modifier.padding(top = 16.dp))

            // Display the description
            Text(text = description, modifier = Modifier.padding(top = 8.dp))
        }
    }
}
