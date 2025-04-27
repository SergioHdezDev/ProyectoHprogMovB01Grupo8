package com.example.proyectopoli.screens.fragments.content

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyectopoli.R
import com.example.proyectopoli.constants.INFO_APP
import com.example.proyectopoli.constants.generateDatePhotos
import kotlinx.coroutines.delay

@Composable
fun DetailPhotoFragment() {
    val detail = generateDatePhotos(0)[0]
    detail.status = false
    val context = LocalContext.current
    val imageResId = context.resources.getIdentifier(detail.img, "drawable", context.packageName)
    var iconHeart by remember { mutableIntStateOf(if (detail.status) R.drawable.heart else R.drawable.heart_disable) }

    var timeLeft by remember { mutableStateOf(0) }
    var isCountingDown by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = detail.title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Row {
                    Icon(
                        painter = painterResource(id = iconHeart),
                        contentDescription = "Ícono de corazón",
                        tint = Color.Red,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                iconHeart =
                                    if (detail.status) R.drawable.heart_disable else R.drawable.heart
                                detail.status = !detail.status
                                Log.w(INFO_APP, "Validator ${detail.status}")
                            }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.whatsapp),
                        contentDescription = "Ícono de WhatsApp",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
            if (imageResId != 0) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Imagen del ejercicio ${detail.title}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.not_found),
                    contentDescription = "Imagen del ejercicio ${detail.title}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(16.dp)
            ) {
                Text(
                    text = "${detail.description}:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Instrucciones para realizar el ejercicio:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = detail.instruction,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.fire),
                        contentDescription = "Ícono de fuego",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "200 Calorías",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                }
                Button(
                    onClick = {
                        timeLeft = detail.duration.toInt()
                        isCountingDown = true
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, Color.Blue)
                ) {
                    Text(
                        text = if (isCountingDown) "Tiempo restante: $timeLeft" else "Iniciar Entrenamiento",
                        color = Color.Blue,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }

    if (isCountingDown) {
        LaunchedEffect(Unit) {
            while (timeLeft > 0) {
                delay(1000)
                timeLeft--
            }
            isCountingDown = false
        }
    }
}