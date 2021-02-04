package com.usu.usuwebpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        AppCompatButton button = new AppCompatButton(this);
        button.setText("PRESS MEE!");
        WebView usuWebView = new WebView(this);
        usuWebView.loadUrl("https://usu.edu");
        usuWebView.setWebViewClient(new WebViewClient());
        mainLayout.addView(button);
        mainLayout.addView(usuWebView);
        setContentView(mainLayout);
    }
}