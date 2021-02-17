package com.usu.josephditton.telephone;

import android.content.Context;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatButton;

public class PhoneButton extends AppCompatButton {
    public PhoneButton(Context context, ButtonData data) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(data.row, 1, 1);
        params.columnSpec = GridLayout.spec(data.col, data.colSpan, 1);
        setLayoutParams(params);
        setTextSize(24);
        setText(data.text);
    }
}
