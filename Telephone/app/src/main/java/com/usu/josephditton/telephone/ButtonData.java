package com.usu.josephditton.telephone;

import android.graphics.Color;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class ButtonData {
    public String text;
    public int row;
    public int col;
    public int colSpan;
    public Integer color;

    public ButtonData(String text, int row, int col, int colSpan) {
        this(text, row, col, colSpan, null);
    }

    public ButtonData(String text, int row, int col, int colSpan, Integer color) {
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
        this.color = color;
    }
}
