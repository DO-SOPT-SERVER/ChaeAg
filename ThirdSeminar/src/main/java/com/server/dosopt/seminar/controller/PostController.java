package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.domain.Message;
import com.server.dosopt.seminar.domain.MessageEnum;
import com.server.dosopt.seminar.domain.Post;
import com.server.dosopt.seminar.domain.StatusEnum;
import com.server.dosopt.seminar.dto.request.post.PostCreateRequest;
import com.server.dosopt.seminar.service.PostService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
    private final PostService postService;

    @GetMapping("{postId}")
    public ResponseEntity<Message> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok().body(Message.of(StatusEnum.OK, MessageEnum.SELECT, postService.getById(postId)));
    }

    @GetMapping
    public ResponseEntity<Message> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
        return ResponseEntity.ok().body(Message.of(StatusEnum.OK, MessageEnum.SELECT, postService.getPosts(memberId)));
    }

    @PostMapping
    public ResponseEntity<Message> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
                                           @RequestBody PostCreateRequest request) {
        Post post = postService.create(request, memberId);
        URI location = URI.create("/api/post/" + post.getId().toString());
        return ResponseEntity.created(location).body(Message.of(StatusEnum.OK, MessageEnum.CRETAE, post));
    }
}
