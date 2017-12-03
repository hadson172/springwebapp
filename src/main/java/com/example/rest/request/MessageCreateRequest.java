package com.example.rest.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageCreateRequest {

    @NotNull
    @NotBlank
    private String receiverUsername;

    @NotNull
    @Size(min = 5, max = 250)
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
