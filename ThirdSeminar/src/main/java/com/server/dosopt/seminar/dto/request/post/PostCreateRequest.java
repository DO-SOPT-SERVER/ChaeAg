package com.server.dosopt.seminar.dto.request.post;

public record PostCreateRequest(
        String title,
        String content
) {
}