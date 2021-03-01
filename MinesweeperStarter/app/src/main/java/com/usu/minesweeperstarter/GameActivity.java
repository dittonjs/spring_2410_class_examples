package com.usu.minesweeperstarter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String gameMode = "easy"; // TODO: Retrieve the game mode from the intent;
        GameView gameView = new GameView(this, gameMode);
        setContentView(gameView);
    }
}
