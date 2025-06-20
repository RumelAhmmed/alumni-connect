package com.example.alumniconnect.controller;

import com.example.alumniconnect.entity.Message;
import com.example.alumniconnect.model.MessageStatus;
import com.example.alumniconnect.model.TypingStatus;
import com.example.alumniconnect.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;

@Controller
public class ChatController {

    private Set<String> onlineUsers = ConcurrentHashMap.newKeySet();

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());
        message.setReceiver(null);
        messageRepository.save(message);
        return message;
    }

    @MessageMapping("/typing")
    @SendTo("/topic/typing")
    public TypingStatus typing(TypingStatus status) {
        return status;
    }

    @MessageMapping("/private")
    public void sendPrivateMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);
        messagingTemplate.convertAndSendToUser(message.getReceiver(), "/queue/messages", message);
    }

    // New handler for online user notification
    @MessageMapping("/online")
    public void userOnlineStatus(MessageStatus status) {
        if (status.getSender() != null && !status.getSender().isEmpty()) {
            onlineUsers.add(status.getSender());
        }
        messagingTemplate.convertAndSend("/topic/online", onlineUsers.size());
    }

    @GetMapping("/chat-history")
    @ResponseBody
    public List<Message> getPublicChatHistory() {
        return messageRepository.findByReceiverIsNullOrderByTimestampAsc();
    }
}
