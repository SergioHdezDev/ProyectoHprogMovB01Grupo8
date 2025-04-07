package com.example.proyectopoli.screens.fragments.content

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.R

@Composable
fun BotonesFragment() {
    CalendarScreen()
}

@Composable
fun CalendarScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF6A40C2))
    ) {
        TopBar()
        CalendarSection()
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Perfil",
            modifier = Modifier.size(60.dp).clip(CircleShape)
        )
        Image(
            painter = painterResource(id = R.drawable.fitu_logo),
            contentDescription = "Logo Fitu",
            modifier = Modifier.size(80.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "Menú",
            modifier = Modifier.size(50.dp),
            tint = Color.White
        )
    }
}

@Composable
fun CalendarSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFB0C4DE)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "March", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))

        // Calendario en una cuadrícula
        CalendarGrid()
    }
}

@Composable
fun CalendarGrid() {
    val days = (1..31).toList() // Días del mes

    LazyVerticalGrid(
        columns = GridCells.Fixed(7), // 7 columnas para 7 días de la semana
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
    ) {
        items(days.size) { index ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(40.dp)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(text = days[index].toString(), fontSize = 16.sp, color = Color.Black)
            }
        }
    }
}
