package com.usu.mspaint;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {
    private Paint paint = new Paint();
    private int color = 0;
    private int x = 100;

    public enum ShapeType {
        CIRCLE,
        RECT,
        LINE,
        SNOWMAN,
    }

    private ShapeType type = ShapeType.CIRCLE;

    public DrawingView(Context context) {
        super(context);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        ValueAnimator animator = ValueAnimator.ofInt(0,  255);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                color = (int)valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();

        ValueAnimator animator2 = ValueAnimator.ofInt(100,  getWidth() - 100);
        animator2.setDuration(2000);
        animator2.setRepeatCount(ValueAnimator.INFINITE);
        animator2.setRepeatMode(ValueAnimator.REVERSE);
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                x = (int)valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator2.start();
    }

    public void setType(ShapeType type) {
        this.type = type;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.rgb(145, 152, color));
        canvas.drawCircle(x, getHeight() / 2, x, paint);

    }
}
