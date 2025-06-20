package com.example.alumniconnect.repository;

import com.example.alumniconnect.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiverIsNullOrderByTimestampAsc(); // public chat messages

    List<Message> findBySenderAndReceiverOrderByTimestampAsc(String sender, String receiver);

    List<Message> findByReceiverAndSenderOrderByTimestampAsc(String receiver, String sender);
}
