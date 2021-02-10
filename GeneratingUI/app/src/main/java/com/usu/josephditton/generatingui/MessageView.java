package com.usu.josephditton.generatingui;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatTextView;

public class MessageView extends LinearLayout {
    public MessageView(Context context, Message message) {
        super(context);
        setOrientation(VERTICAL);
        setBackgroundColor(Color.rgb(0,0,100));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(24,12,24,12);
        setPadding(24,800,24,800);
        setLayoutParams(params);
        AppCompatTextView authorView = new AppCompatTextView(context);
        authorView.setTextColor(Color.WHITE);
        authorView.setText(message.getAuthor());

        AppCompatTextView bodyView = new AppCompatTextView(context);
        bodyView.setTextSize(18);
        bodyView.setTextColor(Color.WHITE);
        bodyView.setText(message.getBody());
        addView(authorView);
        addView(bodyView);
    }
}
