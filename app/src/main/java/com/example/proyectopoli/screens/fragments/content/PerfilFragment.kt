package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.proyectopoli.R

@Composable
fun PerfilFragment() {
    val backgroundColor = Color(0xFF6A42F4)

    Scaffold(
        topBar = { CustomTopAppBar(backgroundColor) },
        bottomBar = { CustomBottomNavigationBar(backgroundColor) }
    ) { innerPadding ->
        ProfileContent(backgroundColor, innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(backgroundColor: Color) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = backgroundColor),
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.fitu_logo),
                    contentDescription = "Logo FiTU",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "FiTU",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Acción del menú */ }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menú",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun ProfileContent(backgroundColor: Color, innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileImage()
            Spacer(modifier = Modifier.height(16.dp))
            ProfileText("Cristian Rodríguez", MaterialTheme.typography.headlineSmall, FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            ProfileText("Puntuación Logros: 7510", MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            ProfileDetail("Edad: 42")
            ProfileDetail("Lema: \"Vivir cada instante\"")
            ProfileDetail("Ubicación: Medellín, Colombia")
            ProfileDetail("Email: cristianrodriguez8@aol.com")
            ProfileDetail("Teléfono: (+57) 380 605 98 77")
        }
    }
}

@Composable
fun ProfileImage() {
    Image(
        painter = painterResource(id = R.drawable.profile_image),
        contentDescription = "Foto de perfil",
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ProfileText(text: String, style: androidx.compose.ui.text.TextStyle, fontWeight: FontWeight? = null) {
    Text(
        text = text,
        style = style.copy(color = Color.White, fontWeight = fontWeight ?: FontWeight.Normal)
    )
}

@Composable
fun ProfileDetail(text: String) {
    ProfileText(text, MaterialTheme.typography.bodyMedium)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomNavigationBar(backgroundColor: Color) {
    NavigationBar(containerColor = backgroundColor) {
        val items = listOf(
            Icons.Default.Home to "Inicio",
            Icons.Default.Person to "Perfil",
            Icons.Default.Settings to "Ajustes"
        )

        items.forEachIndexed { index, (icon, label) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                selected = index == 1, // Perfil seleccionado
                onClick = { /* Navegar */ },
                label = { Text(label) },
                alwaysShowLabel = true
            )
        }
    }
}
