package com.usu.josephditton.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        LabelledInput userNameInput = new LabelledInput(this, "Username");
        LabelledInput passwordInput = new LabelledInput(this, "Password");
        mainLayout.addView(userNameInput);
        mainLayout.addView(passwordInput);
        AppCompatButton loginButton = new AppCompatButton(this);
        loginButton.setText("Login");
        loginButton.setOnClickListener((view) -> {

            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("username", 4);
            intent.putExtra("somenumber", 4.5);
            startActivity(intent);
        });

        mainLayout.addView(loginButton);
        setContentView(mainLayout);
    }



    @Override
    protected void onResume() {
        super.onResume();
        System.out.println();
    }
}