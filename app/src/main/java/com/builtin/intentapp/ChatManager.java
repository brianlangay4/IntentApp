package com.builtin.intentapp;
import java.util.ArrayList;
import java.util.List;

public class ChatManager {

    private static ChatManager instance;
    private List<ChatMessage> chatMessages;

    private ChatManager() {
        chatMessages = new ArrayList<>();
    }

    public static synchronized ChatManager getInstance() {
        if (instance == null) {
            instance = new ChatManager();
        }
        return instance;
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }


    public void addMessage(String sender, String message, int type) {
        chatMessages.add(new ChatMessage(sender, message, type));
    }

}
