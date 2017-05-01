package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.account.User;
import com.example.model.account.role.Role;
import com.example.model.message.Message;
import com.example.repository.MessageRepository;
import com.example.rest.request.MessageCreateRequest;
import com.example.rest.request.MessageType;
import com.example.rest.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository repository;
    private UserService userService;

    @Autowired
    public MessageService(MessageRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public List<Message> getMessages(String username, MessageType messageType) {
        if(messageType == MessageType.RECEIVED) return repository.findAllByReceiverUsername(username);
        else if (messageType == MessageType.SENT) return repository.findAllBySenderUsername(username);
        return repository.findAllBySenderUsernameOrReceiverUsername(username,username);
    }


    public Message createMessageFromRequest(MessageCreateRequest request, Authentication authentication) {
        User sender = userService.getAuthenticatedUser(authentication).orElseThrow(() -> new ResourceNotFoundException("User with given username doesn't exists"));
        User receiver = userService.findUserByUsername(request.getReceiverUsername()).orElseThrow(()-> new ResourceNotFoundException("User-receiver with given username doesn't exists"));

        //if sender is a client then receiver cannot be client, they cannot communicate without knowledge of real estate agency
        if (sender.getAuthorities().contains(Role.CLIENT) && receiver.getAuthorities().contains(Role.CLIENT)) {
            throw new ResourceNotFoundException("Agency employee with given username doesn't exists");
        }

        return new Message(sender,receiver,request.getContent());
    }

    public MessageResponse mapToMessageResponse(Message message) {
        return new MessageResponse(message.getId(),message.getSender().getUsername(),message.getReceiver().getUsername(),message.getContent(),message.getSendDate());
    }

    public Message saveMessage(Message message) {
       return repository.save(message);
    }


}
