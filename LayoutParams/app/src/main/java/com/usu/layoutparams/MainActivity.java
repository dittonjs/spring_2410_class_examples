package com.usu.layoutparams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.resources.TextAppearance;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setBackgroundColor(Color.BLUE);
        LinearLayout.LayoutParams mainLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        mainLayoutParams.setMargins(48, 48, 48, 48);
        mainLayout.setLayoutParams(mainLayoutParams);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        // userName
        AppCompatTextView userNameLabel = new AppCompatTextView(this);
        LinearLayout.LayoutParams userNameLabelParams = new LinearLayout.LayoutParams(
                400,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
//        userNameLabelParams.setMargins(48, 48, 48, 0);
        userNameLabel.setText("Username");
        userNameLabel.setLayoutParams(userNameLabelParams);
        userNameLabel.setBackgroundColor(Color.RED);
        AppCompatEditText userNameEditText = new AppCompatEditText(this);

        int value = 0;
        int value2 = 10 / value;
        // password
        AppCompatTextView passwordLabel = new AppCompatTextView(this);
        passwordLabel.setText("Password");

        AppCompatEditText passwordEditText = new AppCompatEditText(this);
        passwordEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        // submit button
        AppCompatButton submitButton = new AppCompatButton(this);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        submitButton.setLayoutParams(buttonParams);
        submitButton.setText("Submit");

        mainLayout.addView(userNameLabel);
        mainLayout.addView(userNameEditText);
        mainLayout.addView(passwordLabel);
        mainLayout.addView(passwordEditText);
        mainLayout.addView(submitButton);

        setContentView(mainLayout);

    }
}