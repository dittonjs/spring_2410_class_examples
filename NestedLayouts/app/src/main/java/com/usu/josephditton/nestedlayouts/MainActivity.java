package com.usu.josephditton.nestedlayouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setBackgroundColor(Color.LTGRAY);


        // user name
        LinearLayout userNameLayout = new LinearLayout(this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params2.weight = 10000;
        userNameLayout.setLayoutParams(params2);
        userNameLayout.setBackgroundColor(Color.CYAN);
        WebView webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://usu.edu ");
        LinearLayout.LayoutParams webViewParams0 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        webView.setLayoutParams(webViewParams0);
        userNameLayout.addView(webView);

        // Password
        LinearLayout passwordLayout = new LinearLayout(this);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.weight = 1;
        passwordLayout.setLayoutParams(params1);
        passwordLayout.setBackgroundColor(Color.MAGENTA);
        AppCompatTextView passwordLabel = new AppCompatTextView(this);
        passwordLabel.setText("Password: ");
        AppCompatEditText passwordInput = new AppCompatEditText(this);
        passwordLayout.addView(passwordLabel);
        passwordLayout.addView(passwordInput);


        mainLayout.addView(userNameLayout);
        mainLayout.addView(passwordLayout);
        setContentView(mainLayout);

    }
}