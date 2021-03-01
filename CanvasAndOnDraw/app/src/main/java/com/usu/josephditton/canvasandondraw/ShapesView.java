package com.usu.josephditton.canvasandondraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.circularreveal.cardview.CircularRevealCardView;

import java.util.ArrayList;

public class ShapesView extends View {
    private ArrayList<Circle> circles = new ArrayList<>();
    public ShapesView(Context context) {
        super(context);
        setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                Circle circle = new Circle(motionEvent.getX(), motionEvent.getY(), 50);
                circles.add(circle);
                invalidate();
                return true;
            }

            return false;
        });
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
//        for (Circle circle: circles) {
//
//        }
        // is the same as
        circles.forEach((circle) -> {
            circle.draw(canvas, paint);
        });

    }

}
