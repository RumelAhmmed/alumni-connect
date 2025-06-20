package com.example.alumniconnect.service;

import com.example.alumniconnect.entity.Message;
import com.example.alumniconnect.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final MessageRepository messageRepo;

    @Autowired
    public ChatService(MessageRepository messageRepo) {
        this.messageRepo = messageRepo;
    }

    public Message saveMessage(Message message) {
        return messageRepo.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }
}
