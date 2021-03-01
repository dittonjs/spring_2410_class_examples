package com.usu.mspaint;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape {
    public abstract void resize(Point end);
    public abstract void draw(Canvas canvas, Paint paint);
}
