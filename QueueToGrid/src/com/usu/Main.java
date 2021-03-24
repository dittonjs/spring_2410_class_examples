package com.usu;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static char[][] cells = new char[3][3];
    public static void main(String[] args) {
	// write your code here
        ArrayList<C> flatCells = new ArrayList<>();

        for (int i =0; i < 9; i++) {
            if (i < 3) {
                flatCells.add('X');
            } else {
                flatCells.add('0');
            }
        }

        Collections.shuffle(flatCells);

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {


                cells[i][j] = flatCells.remove(0);
            }
        }

        displayCells();

    }

    private static void displayCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.printf(" %c ", cells[i][j]);
            }
            System.out.println();
        }
    }
}
