package com.usu.josephditton.canvasandondraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShapesView shapesView = new ShapesView(this);
        setContentView(shapesView);
    }
}