package com.usu.mspaint;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle extends Shape {
    private float radius;
    private Point start;
    public Circle(float radius, Point start) {
        this.radius = radius;
        this.start = start;
    }

    @Override
    public void resize(Point end) {
        radius = (float)Math.sqrt(Math.pow(end.x - start.x,2) + Math.pow(end.y - start.y,2));
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawCircle(start.x, start.y, radius, paint);
    }
}
