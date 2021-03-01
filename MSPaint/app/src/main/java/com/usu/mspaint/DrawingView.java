package com.usu.mspaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Shape currentShape = null;
    private Paint paint = new Paint();

    public enum ShapeType {
        CIRCLE,
        RECT,
        LINE,
        SNOWMAN,
    }

    private ShapeType type = ShapeType.CIRCLE;

    public DrawingView(Context context) {
        super(context);
        setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                Point start = new Point();
                Shape newShape = null;
                start.x = motionEvent.getX();
                start.y = motionEvent.getY();
                switch (type) {
                    case LINE: {
                        Point end = new Point();
                        end.x = motionEvent.getX();
                        end.y = motionEvent.getY();
                        newShape = new Line(start, end);
                        break;
                    }
                    case RECT:
                        Point end = new Point();
                        end.x = motionEvent.getX();
                        end.y = motionEvent.getY();
                        newShape = new Rectangle(start, end);
                        break;
                    case CIRCLE:
                        newShape = new Circle(1, start);
                        break;
                    case SNOWMAN:
                        newShape = new Snowman(10, start);
                        break;
                    default:
                        break;
                }

                shapes.add(newShape);
                currentShape = newShape;
                invalidate();
                return true;
            }

            if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                Point end = new Point();
                end.x = motionEvent.getX();
                end.y = motionEvent.getY();
                currentShape.resize(end);
                invalidate();
                return true;
            }

            return false;
        });
    }

    public void setType(ShapeType type) {
        this.type = type;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        shapes.forEach(shape -> {
            shape.draw(canvas, paint);
            paint.reset();
        });
    }
}
