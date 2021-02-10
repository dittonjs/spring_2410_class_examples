package com.usu.josephditton.generatingui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Message> messages = FakeDatabase.getMessages();
        ScrollView scrollView = new ScrollView(this);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        for (Message message : messages) {
            MessageView messageView = new MessageView(this, message);
            mainLayout.addView(messageView);
        }

        scrollView.addView(mainLayout);

        setContentView(scrollView);
    }
}