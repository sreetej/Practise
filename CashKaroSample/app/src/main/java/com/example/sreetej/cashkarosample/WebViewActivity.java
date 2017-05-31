package com.example.sreetej.cashkarosample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        setTitle("Webview");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        WebView webView = (WebView) findViewById(R.id.webView);

//        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("https://www.amazon.in/");

    }
}
