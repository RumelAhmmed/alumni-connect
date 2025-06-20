package com.example.alumniconnect.model;

public class MessageStatus {
    private String sender;

    public MessageStatus() {}

    public MessageStatus(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
