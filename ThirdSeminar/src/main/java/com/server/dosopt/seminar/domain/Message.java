package com.server.dosopt.seminar.domain;

import lombok.Data;

@Data
public class Message {

    private StatusEnum status;
    private String message;
    private Object data;

    public Message() {
        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
    }

    public Message(StatusEnum status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Message of(StatusEnum status, MessageEnum type, Object data) {
        return new Message(status, type.message(), data);
    }
}
