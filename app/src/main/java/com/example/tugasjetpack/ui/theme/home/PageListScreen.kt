package com.example.tugasjetpack.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.tugasjetpack.R // Import the correct R class for accessing drawable resources

@Composable

fun PageListScreen(navController: NavController) {
    // List of image resources
    val foodImages = listOf(
        R.drawable.food_image_1, R.drawable.food_image_2, R.drawable.food_image_3,
        R.drawable.food_image_4, R.drawable.food_image_5, R.drawable.food_image_6,
        R.drawable.food_image_7, R.drawable.food_image_8, R.drawable.food_image_9,
        R.drawable.food_image_10
    )

    // List of titles
    val titles = listOf(
        "Avocado", "Cherry", "Orange", "Cabbage", "Watermelon",
        "Peach", "Donut", "Candy", "Macaron", "Rainbow Candy"
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Enable scrolling
    ) {
        // LazyColumn Section
        Text(
            "Lazy Column",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(modifier = Modifier.height(400.dp)) {
            items(10) { index ->
                ListItemWithImage(
                    foodImage = foodImages[index],
                    title = titles[index],
                    description = "Description of ${titles[index]}",
                    navController = navController
                )
            }
        }

        // LazyRow Section
        Text(
            "Lazy Row",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(8.dp)
        )
        LazyRow(modifier = Modifier.height(150.dp)) {
            items(10) { index ->
                ListItemWithImage(
                    foodImage = foodImages[index],
                    title = titles[index],
                    description = "Description of ${titles[index]}",
                    navController = navController
                )
            }
        }

        // Navigation trigger for LazyGrid screen

    }
}


@Composable
fun ListItemWithImage(foodImage: Int, title: String, description: String, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                // Passing image, title, and description to the DetailScreen
                navController.navigate("detail_screen/$foodImage/$title/$description")
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imagePainter: Painter = painterResource(id = foodImage)
        Image(painter = imagePainter, contentDescription = title, modifier = Modifier.size(100.dp))
        Text(text = title, modifier = Modifier.padding(top = 8.dp))
    }
}
