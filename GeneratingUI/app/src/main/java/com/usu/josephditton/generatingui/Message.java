package com.usu.josephditton.generatingui;

public class Message {
    private String author;
    private String body;

    public Message(String author, String body) {
        this.author = author;
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }
}
