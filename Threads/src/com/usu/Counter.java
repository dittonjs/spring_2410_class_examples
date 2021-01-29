package com.usu;

public class Counter implements Runnable {
    private int currentCount = 0;
    private int maxCount;

    public Counter(int count) {
        maxCount = count;
    }

    @Override
    public void run() {
        while(currentCount <= maxCount) {
            System.out.println(currentCount);
            currentCount ++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        new Thread(this).start();
    }
}
