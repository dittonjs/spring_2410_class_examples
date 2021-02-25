package com.usu.josephditton.canvasandondraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class ShapesView extends View {
    public ShapesView(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(14);
//        canvas.drawCircle(60, 60, 60, paint);
//        paint.reset();
//        paint.setColor(Color.GREEN);
//        canvas.drawCircle(60, 60, 50, paint);
//        paint.setColor(Color.BLUE);
//        canvas.drawRect(10, 120, 110, 170, paint);
//
//        paint.setColor(Color.GREEN);
//        canvas.drawLine(10, 180, 110, 280, paint);
//
//        paint.setColor(Color.BLACK);
//        canvas.drawRoundRect(10, 290, 310, 490, 50, 50, paint);
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.rotate(45);
        canvas.drawRect(
                0 - 50,
                0 - 50,
                0 + 50,
                0 + 50,
                paint
        );
        canvas.restore();
        canvas.save();
        canvas.translate(800, 300);
        canvas.rotate(18);
        canvas.drawRect(-50, -50, 50, 50, paint);
        canvas.restore();
    }

    public void drawRectWithRotation(float top, float left, float bottom, float right, float rotation, Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(800, 300);
        canvas.rotate(18);
        canvas.drawRect(-50, -50, 50, 50, paint);
        canvas.restore();
    }
}
