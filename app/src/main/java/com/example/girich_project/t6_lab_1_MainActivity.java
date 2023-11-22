package com.example.girich_project;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;


public class t6_lab_1_MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t6_lab_1_activity_main);

//        WebView browser=findViewById(R.id.webBrowser);
//        browser.loadUrl("https://metanit.com");

//        WebView browser = new WebView(this);
//        setContentView(browser);
//        browser.loadUrl("http://metanit.com");

//        WebView browser= findViewById(R.id.webBrowser);
//        browser.loadData("<html><body><h2>Hello, Android!</h2>" +
//                " </body></html>", "text/html", "UTF-8");


        WebView browser = findViewById(R.id.webBrowser);
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }


}