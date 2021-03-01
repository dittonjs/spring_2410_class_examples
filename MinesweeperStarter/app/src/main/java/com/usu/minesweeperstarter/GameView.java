package com.usu.minesweeperstarter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;

public class GameView extends View {
    Game game;
    Paint paint = new Paint();
    String gameMode;
    public GameView(Context context, String gameMode) {
        super(context);
        this.gameMode = gameMode;

        // TODO: Define a GestureDetectorCompat with an onSingleTapUp method
        //      and and onLongPress method.
        //      For each method, notify the game while action was performed with the motion Event.
        //      Don't forget to call invalidate()


        setOnTouchListener((view, e) -> {
            // TODO: use your gesture detector here.
            return false;
        });
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        game = new Game(gameMode, getWidth(), getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        game.draw(canvas, paint);
    }
}
