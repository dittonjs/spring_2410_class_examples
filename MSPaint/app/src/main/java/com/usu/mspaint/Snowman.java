package com.usu.mspaint;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Snowman extends Shape {
    private float radius;
    private float radiusTop;
    private float radiusBottom;
    private Point start;
    public Snowman(float radius, Point start) {
        this.radius = radius;
        this.start = start;
    }

    @Override
    public void resize(Point end) {
        radius = (float)Math.sqrt(Math.pow(end.x - start.x,2) + Math.pow(end.y - start.y,2));
        radiusTop = radius * .8f;
        radiusBottom = radius * 1.2f;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawCircle(start.x, start.y - radius + 10, radiusTop, paint);
        canvas.drawCircle(start.x, start.y, radius, paint);
        canvas.drawCircle(start.x, start.y + radius - 10, radiusBottom, paint);
    }
}
