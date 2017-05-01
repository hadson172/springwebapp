package com.example.rest.message;

import com.example.model.message.Message;
import com.example.rest.request.MessageCreateRequest;
import com.example.rest.request.MessageType;
import com.example.rest.response.MessageResponse;
import com.example.service.MessageService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${path.msg}")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<MessageResponse> getAllMessages(@RequestParam(name = "type") Optional<MessageType> messageTypeOptional, Authentication authentication) {
       return messageTypeOptional.map(messageType -> messageService.getMessages(authentication.getName(),messageType))
               .orElseGet(() -> messageService.getMessages(authentication.getName(),MessageType.ALL))
               .stream().map(messageService::mapToMessageResponse).collect(Collectors.toList());
    }

    @PostMapping
    public void addMessage(MessageCreateRequest messageCreateRequest,Authentication authentication) {
        messageService.saveMessage(messageService.createMessageFromRequest(messageCreateRequest,authentication));
    }

}
