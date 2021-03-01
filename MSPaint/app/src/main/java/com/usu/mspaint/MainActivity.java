package com.usu.mspaint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout buttonsLayout = new LinearLayout(this);
        DrawingView drawingView = new DrawingView(this);
        for(DrawingView.ShapeType type : DrawingView.ShapeType.values()) {
            AppCompatButton button = new AppCompatButton(this);
            button.setText(type.toString());
            button.setOnClickListener((view) -> {
                drawingView.setType(type);
            });
            buttonsLayout.addView(button);
        }

        mainLayout.addView(buttonsLayout);
        mainLayout.addView(drawingView);

        setContentView(mainLayout);
    }
}