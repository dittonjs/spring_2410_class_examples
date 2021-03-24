package com.usu.declarativeui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        EditText userNameEditText = findViewById(R.id.email_edit_text);
//        EditText passwordEditText = findViewById(R.id.password_edit_text);
//        Button loginButton = findViewById(R.id.login_button);
//
//        loginButton.setOnClickListener((view) -> {
//            System.out.println(userNameEditText.getText().toString());
//            System.out.println(passwordEditText.getText().toString());
//        });
    }
}