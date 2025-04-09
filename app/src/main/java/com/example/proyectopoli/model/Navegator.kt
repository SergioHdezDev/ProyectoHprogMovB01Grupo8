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

        miVisorWeb.loadUrl("https://www.google.com")
        miVisorWeb.settings.javaScriptEnabled = true
        miVisorWeb.settings.allowContentAccess = true
        miVisorWeb.settings.setSupportZoom(true)
        miVisorWeb.settings.domStorageEnabled = true
        miVisorWeb.settings.useWideViewPort = true
        miVisorWeb.settings.setAppCacheEnabled(true)


    }

}