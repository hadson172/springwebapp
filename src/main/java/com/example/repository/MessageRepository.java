package com.example.repository;

import com.example.model.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByReceiverUsername(String username);

    List<Message> findAllBySenderUsername(String username);

    List<Message> findAllBySenderUsernameOrReceiverUsername(String senderUsername, String receiverUsername);
}
