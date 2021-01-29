package com.usu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        Looper uiThread = new Looper();
        uiThread.start();

        uiThread.addEventListener("touch", new EventListener() {
            @Override
            public void onEvent() {
                System.out.println("You touched the screen!");
            }
        });

        uiThread.addEventListener("swipe", new EventListener() {
            @Override
            public void onEvent() {
                System.out.println("You swiped the screen!");
            }
        });

        while(!userInput.equals("exit")) {
            System.out.println("Enter a command: ");
            userInput = scanner.next();
            uiThread.addEvent(userInput);
        }

        uiThread.stop();
    }
}
