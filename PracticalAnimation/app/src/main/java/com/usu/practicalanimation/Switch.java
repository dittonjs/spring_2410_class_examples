package com.usu.practicalanimation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.renderscript.Sampler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.core.view.GestureDetectorCompat;

public class Switch extends View {
    int height = 120;
    int width = 200;
    int x = 60;
    boolean isOn = false;
    Paint paint = new Paint();
    ValueAnimator animator;

    public Switch(Context context) {
        super(context);
        setMinimumHeight(height);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        setLayoutParams(params);
//        setBackgroundColor(Color.rgb(0, 200, 100));

        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                // use the event to determine where they pressed if needed
                isOn = !isOn;
                startAnimation();
                invalidate();
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                // tell you game to mark the cell
            }
        });

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetectorCompat.onTouchEvent(motionEvent);
            }
        });
    }

    private void startAnimation() {
        if (animator != null) {
            animator.cancel();
        }

        animator = ValueAnimator.ofInt(x, isOn ? width - 40 : 60);
        animator.setDuration(80);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                x = (int)valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        canvas.drawRoundRect(10, 10, 10 + width, height - 10, 50, 50, paint );
        paint.reset();

        paint.setColor(getResources().getColor(R.color.teal_200, null));

        canvas.drawCircle(x, 60, 50, paint);
        paint.reset();
    }
}
