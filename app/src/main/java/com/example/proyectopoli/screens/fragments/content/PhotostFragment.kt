package com.example.proyectopoli.screens.fragments.content

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectopoli.R
import com.example.proyectopoli.constants.INFO_APP
import com.example.proyectopoli.constants.generateDatePhotos
import com.example.proyectopoli.model.CardPhoto
import com.google.gson.Gson


@Composable
fun PhotosFragment() {
    val start = 0
    val navController = rememberNavController()
    val photos = remember { mutableStateListOf<CardPhoto>() }
    val listState = rememberLazyListState()
    val isLoading = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        photos.addAll(generateDatePhotos(start))
    }
    /*
        LaunchedEffect(listState) {
            snapshotFlow { listState.firstVisibleItemIndex + listState.layoutInfo.visibleItemsInfo.size >= photos.size }
                .collect { isAtEnd ->
                    if (isAtEnd && !isLoading.value) {
                        isLoading.value = true
                        start += 2
                        kotlinx.coroutines.delay(1000)
                        photos.addAll(generateDatePhotos(start))
                        isLoading.value = false
                    }
                }
        }*/

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(5.dp)
        ) {
            items(photos) { photo ->
                PhotoCard(photo, navController)
            }
            if (isLoading.value) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

@Composable
fun PhotoCard(exercise: CardPhoto, navController: NavController) {
    val context = LocalContext.current
    val imageResId = context.resources.getIdentifier(exercise.img, "drawable", context.packageName)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                val exerciseSelect = Gson().toJson(exercise)
                Log.w(INFO_APP, "Ejercicio select ${exerciseSelect}")
                Log.w(INFO_APP, "context ${context.packageName}")
                navController.navigate("${context.packageName}/screens/fragments/content/DetailPhotoFragment")
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = exercise.title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Duración: ${exercise.duration} Ms",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            if (imageResId != 0) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Imagen del ejercicio $exercise.title",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.not_found),
                    contentDescription = "Imagen del ejercicio $exercise.title",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}
