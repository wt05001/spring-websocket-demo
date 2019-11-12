package com.example.websocketdemo.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private String jobId;

    /**
     * the time of message
     */
    private Instant time = Instant.now();

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
