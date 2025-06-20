package com.example.alumniconnect.model;

public class TypingStatus {
    private String sender;

    public TypingStatus() {}
    public TypingStatus(String sender) { this.sender = sender; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
}
