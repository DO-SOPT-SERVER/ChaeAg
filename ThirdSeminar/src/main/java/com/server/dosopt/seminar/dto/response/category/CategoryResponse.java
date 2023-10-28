package com.server.dosopt.seminar.dto.response.category;

import com.server.dosopt.seminar.domain.Category;

public record CategoryResponse(
        String content
)
{
    public static CategoryResponse of(Category category) {
        return new CategoryResponse(category.getContent());
    }
}
