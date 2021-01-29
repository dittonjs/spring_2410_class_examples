package com.usu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean waitForInput = true;
        Scanner scanner = new Scanner(System.in);

        while(waitForInput) {
            System.out.println("Type in an integer: ");
            int value = scanner.nextInt();
            Counter counter = new Counter(value);
            counter.start();
            // do something with value
        };

        System.out.println("Hello, world;");

    }
}
