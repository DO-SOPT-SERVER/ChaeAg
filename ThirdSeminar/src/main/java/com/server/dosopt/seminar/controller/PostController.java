package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.domain.Message;
import com.server.dosopt.seminar.domain.MessageEnum;
import com.server.dosopt.seminar.domain.StatusEnum;
import com.server.dosopt.seminar.dto.request.post.PostCreateRequest;
import com.server.dosopt.seminar.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;

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
    public ResponseEntity<Void> createPost(
            @RequestBody PostCreateRequest request,
            Principal principal) {

        Long memberId = Long.valueOf(principal.getName());
        URI location = URI.create("/api/posts/" + postService.create(request, memberId));

        return ResponseEntity.created(location).build();
    }
}
