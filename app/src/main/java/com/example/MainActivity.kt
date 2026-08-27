package com.example

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        Scaffold(
          modifier = Modifier
            .fillMaxSize()
            .testTag("main_scaffold")
        ) { innerPadding ->
          CertifyHubApp(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun CertifyHubApp(modifier: Modifier = Modifier) {
  var webViewInstance by remember { mutableStateOf<WebView?>(null) }
  var canGoBack by remember { mutableStateOf(false) }

  BackHandler(enabled = canGoBack) {
    webViewInstance?.goBack()
  }

  Box(
    modifier = modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.background)
      .testTag("webview_container")
  ) {
    AndroidView(
      modifier = Modifier
        .fillMaxSize()
        .testTag("certifyhub_webview"),
      factory = { context ->
        WebView(context).apply {
          layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
          )
          settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
            allowFileAccess = true
            allowContentAccess = true
            cacheMode = WebSettings.LOAD_DEFAULT
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            // Safe rendering & performance settings
            setRenderPriority(WebSettings.RenderPriority.HIGH)
          }
          setLayerType(android.view.View.LAYER_TYPE_HARDWARE, null)
          webChromeClient = WebChromeClient()
          webViewClient = object : WebViewClient() {
            override fun onReceivedError(
              view: WebView?,
              errorCode: Int,
              description: String?,
              failingUrl: String?
            ) {
              super.onReceivedError(view, errorCode, description, failingUrl)
            }
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
              super.onPageStarted(view, url, favicon)
              canGoBack = view?.canGoBack() ?: false
            }

            override fun onPageFinished(view: WebView?, url: String?) {
              super.onPageFinished(view, url)
              canGoBack = view?.canGoBack() ?: false
            }

            override fun shouldOverrideUrlLoading(
              view: WebView?,
              request: WebResourceRequest?
            ): Boolean {
              return false
            }
          }
          loadUrl("file:///android_asset/index.html")
          webViewInstance = this
        }
      },
      update = { webView ->
        webViewInstance = webView
      }
    )
  }
}

