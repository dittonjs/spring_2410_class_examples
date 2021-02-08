package com.usu.josephditton.customcomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.usu.josephditton.customcomponents.components.CustomButton;
import com.usu.josephditton.customcomponents.components.LabelledInput;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        // form fields
        LabelledInput nameInput = new LabelledInput(this, "Name");
        LabelledInput emailInput = new LabelledInput(this, "Email");

        LabelledInput phoneInput = new LabelledInput(this, "Phone Number");
        LabelledInput addressInput = new LabelledInput(this, "Address");

        LabelledInput bloodTypeInput = new LabelledInput(this, "Blood Type");
        LabelledInput ssnInput = new LabelledInput(this, "SSN");


        mainLayout.addView(nameInput);
        mainLayout.addView(emailInput);
        mainLayout.addView(phoneInput);
        mainLayout.addView(addressInput);
        mainLayout.addView(bloodTypeInput);
        mainLayout.addView(ssnInput);

        CustomButton button = new CustomButton(this);
        button.setText("Save");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("", "I am the first");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("", "I am the second");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("", "I am the third");
            }
        });
        mainLayout.addView(button);

        setContentView(mainLayout);

    }
}