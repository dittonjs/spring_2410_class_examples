package com.usu.josephditton.telephone;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatButton;

public class PhoneButton extends AppCompatButton {
    public PhoneButton(Context context, ButtonData data) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(data.row, 1, 1);
        params.columnSpec = GridLayout.spec(data.col, data.colSpan, 1);
        params.setMargins(6,6,6,6);
        setLayoutParams(params);

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    setBackgroundColor(getResources().getColor(R.color.active_button_color, null));
                } else if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    setBackgroundColor(data.color == null ? getResources().getColor(R.color.teal_700, null) : data.color);
                }
                return false;
            }
        });

        if (data.color != null) {
            setBackgroundColor(data.color);
        } else {
            setBackgroundColor(getResources().getColor(R.color.teal_700, null));
        }

        setTextSize(24);
        setText(data.text);
    }
}
