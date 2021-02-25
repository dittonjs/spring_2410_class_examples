package com.usu.josephditton.multipleactivities;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

public class LabelledInput extends LinearLayout {
    AppCompatEditText editText;
    public LabelledInput(Context context, String label) {
        super(context);
        setOrientation(VERTICAL);
        AppCompatTextView textView = new AppCompatTextView(context);
        textView.setText(label);
//        setText
        editText = new AppCompatEditText(context);

        addView(textView);
        addView(editText);
    }

    public String getText() {
        return editText.getText().toString();
    }
}
