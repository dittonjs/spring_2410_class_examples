package com.usu.josephditton.telephone;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatTextView;

public class PhoneNumberDisplay extends AppCompatTextView {
    String phoneNumber = "";

    public PhoneNumberDisplay(Context context) {
        super(context);
        setText(phoneNumber);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(0, 1, 1);
        params.columnSpec = GridLayout.spec(0, 3, 1);
        setGravity(Gravity.CENTER);
        setTextSize(24);
        setLayoutParams(params);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        setText(phoneNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
