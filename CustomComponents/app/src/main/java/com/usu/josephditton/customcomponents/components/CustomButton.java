package com.usu.josephditton.customcomponents.components;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;

public class CustomButton extends AppCompatButton {
    ArrayList<OnClickListener> listeners = new ArrayList<OnClickListener>();
    public CustomButton(@NonNull Context context) {
        super(context);
        setBackgroundColor(Color.CYAN);
        super.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(OnClickListener listener: listeners) {
                    listener.onClick(view);
                }
                Log.d("", "Log me!!!!");
            }
        });
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        listeners.add(l);
    }
}
