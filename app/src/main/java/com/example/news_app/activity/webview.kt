package com.example.news_app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.news_app.R
import kotlinx.android.synthetic.main.activity_webview.*

class webview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        val webviewuser=intent.getStringExtra("web")
        if(webviewuser!=null){
            web_view.settings.javaScriptEnabled=true
            web_view.settings.userAgentString=" Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; SCH-I535 Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"
            web_view.webViewClient=object :WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    web_view.visibility=View.VISIBLE
                    progressbar.visibility=View.GONE
                }
            }
           web_view.loadUrl(webviewuser)
        }

    }
}