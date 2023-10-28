package com.server.dosopt.seminar.domain;

import lombok.Data;

public record Message(
        StatusEnum status,
        String message,
        Object data)
{
    public static Message of(StatusEnum status, MessageEnum type, Object data) {
        return new Message(status, type.message(), data);
    }
}
