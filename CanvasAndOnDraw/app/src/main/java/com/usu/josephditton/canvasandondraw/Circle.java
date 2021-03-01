package com.usu.josephditton.canvasandondraw;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle {
    private float radius;
    private float cx;
    private float cy;

    public Circle(float cx, float cy, float radius) {
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
    }


    public void draw(Canvas canvas, Paint paint) {
        canvas.drawCircle(cx, cy, radius, paint);
    }
}
