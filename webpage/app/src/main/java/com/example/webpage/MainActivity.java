package com.example.webpage;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.*;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button loadS, loadU;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadS = findViewById(R.id.loadStatic);
        loadU = findViewById(R.id.loadFromURL);
        webView = (WebView)(findViewById(R.id.webView));
        loadS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String staticHTML = "<html><body><h1> This is Moniesh Ravichandran</h1><h2>I am from  SSN</h2><h3> My Hobbies are : </h3><ul><li>Playing Cricket</li><li>Watching Football</li></ul></body></html>";
                webView.loadData(staticHTML,"text/html","utf-8");
            }
        });

        loadU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = "https://www.google.com";
                webView.loadUrl(URL);
            }
        });
    }
}