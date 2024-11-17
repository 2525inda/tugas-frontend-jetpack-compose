package com.example.tugasjetpack.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasjetpack.R

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp, start = 16.dp, end = 16.dp, bottom = 16.dp), // Top margin of 50.dp
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Image with CircleShape
        Image(
            painter = painterResource(id = R.drawable.profile_image), // Ensure this drawable exists
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(200.dp) // Size of the profile image
                .padding(bottom = 16.dp) // Space below the image
        )

        // Name
        Text(
            text = "Inda Umami",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp)) // Space between Name and Email

        // Email
        Text(
            text = "indaumami2525@gmail.com",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(12.dp)) // Space between Email and University

        // University
        Text(
            text = "Universitas Malikussaleh",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp)) // Space between University and Major

        // Major
        Text(
            text = "Sistem Informasi",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
