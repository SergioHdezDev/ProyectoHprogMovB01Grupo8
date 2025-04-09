package com.example.proyectopoli.model

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class Navegator : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val miVisorWeb: WebView = findViewById(R.id.miviorweb)
        miVisorWeb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view : webview?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }
    }

}