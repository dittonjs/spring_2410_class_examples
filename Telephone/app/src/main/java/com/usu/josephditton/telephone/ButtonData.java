package com.usu.josephditton.telephone;

public class ButtonData {
    public String text;
    public int row;
    public int col;
    public int colSpan;

    public ButtonData(String text, int row, int col, int colSpan) {
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
    }
}
