package com.server.dosopt.seminar.dto.response.post;

import com.server.dosopt.seminar.domain.Category;
import com.server.dosopt.seminar.domain.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content,
        Category category
) {
    public static PostGetResponse of(Post post, Category category) {
        return new PostGetResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                category
        );
    }
}
