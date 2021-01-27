package com.usu.basicandroidviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        AppCompatTextView instructionsTextView = new AppCompatTextView(this);
        instructionsTextView.setText("Please enter your name");

        AppCompatEditText nameEditText = new AppCompatEditText(this);
        nameEditText.setHint("Your name here");

        AppCompatButton displayMessageButton = new AppCompatButton(this);
        displayMessageButton.setText("Display Message");

        AppCompatTextView messageTextView = new AppCompatTextView(this);

        displayMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usersName = nameEditText.getText().toString();
                messageTextView.setText("Hi " + usersName + ", welcome to our application!");
            }
        });

        mainLayout.addView(instructionsTextView);
        mainLayout.addView(nameEditText);
        mainLayout.addView(displayMessageButton);
        mainLayout.addView(messageTextView);
        setContentView(mainLayout);
    }
}