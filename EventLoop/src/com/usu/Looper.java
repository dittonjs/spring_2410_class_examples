package com.usu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Looper implements Runnable {
    boolean running = false;
    Queue<String> eventQueue = new LinkedList<>();
    HashMap<String, ArrayList<EventListener>> eventListeners = new HashMap<>();

    @Override
    public void run() {
        while(running) {
            while(!eventQueue.isEmpty()) {
                synchronized (eventQueue) {
                    String event = eventQueue.poll();
                    ArrayList<EventListener> listeners = eventListeners.get(event);
                    if ( listeners != null) {
                        for(EventListener listener : listeners) {
                            listener.onEvent();
                        }
                    }
                }
            }
            synchronized (eventQueue) {
                try {
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void stop() {
        running = false;
    }

    public void addEvent(String event) {
        synchronized (eventQueue) {
            eventQueue.add(event);
            eventQueue.notify();
        }
    }

    public void addEventListener(String event, EventListener listener) {
        if (eventListeners.get(event) == null) {
            eventListeners.put(event, new ArrayList<>());
        }

        eventListeners.get(event).add(listener);
    }
}
