package com.example.alumniconnect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@Component
public class WebSocketEventListener {

    private final Set<String> onlineUsers = new ConcurrentSkipListSet<>();

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @EventListener
    public void handleSessionConnected(SessionConnectEvent event) {
        // Can extract username from headers if sent on connect
    }

    @EventListener
    public void handleSessionSubscribeEvent(SessionSubscribeEvent event) {
        // Handle subscriptions if needed
    }

    @EventListener
    public void handleSessionDisconnect(SessionDisconnectEvent event) {
        // Remove user on disconnect
        // You would need to map sessions to usernames to do this
    }

    public void addUser(String username) {
        onlineUsers.add(username);
        messagingTemplate.convertAndSend("/topic/onlineUsers", onlineUsers);
    }

    public void removeUser(String username) {
        onlineUsers.remove(username);
        messagingTemplate.convertAndSend("/topic/onlineUsers", onlineUsers);
    }
}
