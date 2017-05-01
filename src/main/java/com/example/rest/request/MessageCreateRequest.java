package com.example.rest.request;

public class MessageCreateRequest {

    private String receiverUsername;
    private String content;

    public MessageCreateRequest() {
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public String getContent() {
        return content;
    }
}
