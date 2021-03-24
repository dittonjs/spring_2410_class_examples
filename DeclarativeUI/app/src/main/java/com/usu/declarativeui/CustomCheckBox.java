package com.usu.declarativeui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomCheckBox extends View {
    int dimensions = 64;
    boolean isChecked = false;
    Paint paint = new Paint();
    public CustomCheckBox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(68, 68);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        canvas.drawRoundRect(2, 2, 2 +dimensions, 2 + dimensions, 4,4, paint);

    }
}
