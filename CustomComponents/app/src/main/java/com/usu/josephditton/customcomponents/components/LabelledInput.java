package com.usu.josephditton.customcomponents.components;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

public class LabelledInput extends LinearLayout {
    private AppCompatEditText input;

    public LabelledInput(Context context, String labelText) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        AppCompatTextView label = new AppCompatTextView(context);
        label.setTextSize(24);
        label.setText(labelText);
        addView(label);
        input = new AppCompatEditText(context);
        addView(input);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 24, 0, 0);
        setLayoutParams(params);
    }

    public String getText() {
        return input.getText().toString();
    }
}
