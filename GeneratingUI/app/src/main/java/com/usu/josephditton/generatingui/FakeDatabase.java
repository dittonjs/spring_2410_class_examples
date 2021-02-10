package com.usu.josephditton.generatingui;

import java.util.ArrayList;
import java.util.Random;

public class FakeDatabase {
    public static ArrayList<Message> getMessages() {
        ArrayList<Message> messages = new ArrayList<>();

        int count = (new Random()).nextInt(15) + 15;
        for (int i = 0; i < count; i++) {
            Message message = new Message("Person " + i, "I am a message");
            messages.add(message);
        }
        return messages;
    }
}
