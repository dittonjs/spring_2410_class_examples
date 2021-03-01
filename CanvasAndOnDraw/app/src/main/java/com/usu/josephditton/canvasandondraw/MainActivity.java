package com.usu.josephditton.canvasandondraw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShapesView shapesView = new ShapesView(this);
        AppCompatEditText textView = new AppCompatEditText(this);
        textView.setText();
        setContentView(shapesView);
    }
}