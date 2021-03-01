package com.usu.mspaint;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Line extends Shape {
    private Point start;
    private Point end;
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void resize(Point end) {
        this.end = end;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(18);
        canvas.drawLine(start.x, start.y, end.x, end.y, paint);
    }
}
