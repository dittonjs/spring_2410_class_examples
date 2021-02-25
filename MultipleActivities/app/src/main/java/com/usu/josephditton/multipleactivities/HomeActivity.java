package com.usu.josephditton.multipleactivities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");
        if(userName == null) {
            // handle
        }
        double myValue = intent.getDoubleExtra("somenumber", 1.0);
        AppCompatTextView textView = new AppCompatTextView(this);
        textView.setText("Hello, " + userName + "! Welcome to the home screen!");
        setContentView(textView);
    }
}
