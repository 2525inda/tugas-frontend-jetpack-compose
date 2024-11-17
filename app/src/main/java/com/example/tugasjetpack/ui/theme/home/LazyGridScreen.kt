package com.example.tugasjetpack.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasjetpack.R

@Composable
fun LazyGridScreen(navController: NavController) {
    val foodImages = listOf(
        R.drawable.food_image_1, R.drawable.food_image_2, R.drawable.food_image_3,
        R.drawable.food_image_4, R.drawable.food_image_5, R.drawable.food_image_6,
        R.drawable.food_image_7, R.drawable.food_image_8, R.drawable.food_image_9,
        R.drawable.food_image_10
    )

    val titles = listOf(
        "Avocado", "Cherry", "Orange", "Cabbage", "Watermelon",
        "Peach", "Donut", "Candy", "Macaron", "Rainbow Candy"
    )

    val descriptions = List(10) { "Lorem ipsum dolor sit amet, consectetur adipiscing elit." }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title Text
        Text(
            "Lazy Grid Screen",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Scrollable LazyVerticalGrid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize() // Ensure the LazyVerticalGrid occupies the remaining space
        ) {
            items(foodImages.indices.toList()) { index ->
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            // Navigate to DetailScreen with arguments
                            navController.navigate("detail_screen/${foodImages[index]}/${titles[index]}/${descriptions[index]}")
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val imagePainter: Painter = painterResource(id = foodImages[index])
                    Image(
                        painter = imagePainter,
                        contentDescription = titles[index],
                        modifier = Modifier.size(100.dp)
                    )
                    Text(text = titles[index], modifier = Modifier.padding(top = 8.dp))
                }
            }
        }
    }
}
