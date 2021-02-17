package com.usu.josephditton.telephone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ButtonData> buttonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inializeData();
        consumeListener(() -> {
            System.out.println();
        });
        GridLayout mainLayout = new GridLayout(this);
        mainLayout.setColumnCount(3);
        PhoneNumberDisplay display = new PhoneNumberDisplay(this);
        mainLayout.addView(display);
        for(ButtonData data: buttonData) {
            PhoneButton button = new PhoneButton(this, data);
            button.setOnClickListener((view) -> {
                if (data.text.equals("CALL")) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+display.getPhoneNumber()));
                    startActivity(intent);
                } else if(data.text.equals("CLEAR")) {
                    display.setPhoneNumber("");
                } else {
                    display.setPhoneNumber(display.getPhoneNumber() + data.text);
                }
            });
            mainLayout.addView(button);
        }

        setContentView(mainLayout);
    }

    private void consumeListener(MyEventListener listener) {
        listener.onEvent();
    }

    private void inializeData() {
        buttonData = new ArrayList<ButtonData>(){
            {
                add(new ButtonData("1", 1, 0, 1));
                add(new ButtonData("2", 1, 1, 1));
                add(new ButtonData("3", 1, 2, 1));
                add(new ButtonData("4", 2, 0, 1));
                add(new ButtonData("5", 2, 1, 1));
                add(new ButtonData("6", 2, 2, 1));
                add(new ButtonData("7", 3, 0, 1));
                add(new ButtonData("8", 3, 1, 1));
                add(new ButtonData("9", 3, 2, 1));
                add(new ButtonData("*", 4, 0, 1));
                add(new ButtonData("0", 4, 1, 1));
                add(new ButtonData("#", 4, 2, 1));
                add(new ButtonData("CALL", 5, 0, 2));
                add(new ButtonData("CLEAR", 5, 2, 1));
            }
        };
    }
}