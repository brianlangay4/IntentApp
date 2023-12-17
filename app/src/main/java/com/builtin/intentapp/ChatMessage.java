package com.builtin.intentapp;

public class ChatMessage {
    private String sender;
    private String message;
    private int type; // 0 for RECEIVED, 1 for SENT

    public ChatMessage(String sender, String message, int type) {
        this.sender = sender;
        this.message = message;
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public int getType() {
        return type;
    }
}
