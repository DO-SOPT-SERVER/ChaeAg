package com.server.dosopt.seminar.dto.request.post;

import com.server.dosopt.seminar.domain.CategoryId;

public record PostCreateRequest(
        String title,
        String content,
        CategoryId categoryId
) {
}