package com.example.proyectopoli.screens.fragments.content

import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.proyectopoli.constants.formatUrl

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebFragment() {
    var url by remember { mutableStateOf("www.poli.edu.co") }
    var webViewVisible by remember { mutableStateOf(false) }
    var webViewRef by remember { mutableStateOf<WebView?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = url,
                onValueChange = { url = it },
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text(
                        "Busca una url"
                    )
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    webViewVisible = true
                    webViewRef?.loadUrl(formatUrl(url))
                }
            ) {
                Text("Buscar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        if (webViewVisible) {
            AndroidView(
                factory = { context ->
                    WebView(context).apply {
                        settings.apply {
                            domStorageEnabled = true
                            databaseEnabled = true
                            javaScriptEnabled = true
                            cacheMode = WebSettings.LOAD_DEFAULT
                        }
                        clearCache(true)
                        clearHistory()
                        clearFormData()

                        loadUrl(formatUrl(url))
                        webViewRef = this
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}