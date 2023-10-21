package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.domain.Message;
import com.server.dosopt.seminar.dto.MemberCreateRequest;
import com.server.dosopt.seminar.dto.MemberGetResponse;
import com.server.dosopt.seminar.dto.MemberUpdateRequest;
import com.server.dosopt.seminar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 특정 멤버 조회 (예외 처리 X)
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getByIdV1(memberId));
    }

    // 특정 멤버 조회 (예외 처리 O)
    @GetMapping(value = "{memberId}/v2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getByIdV2(memberId));
    }

    // 멤버 목록 조회
    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    // 멤버 생성
    @PostMapping
    public ResponseEntity<Message> createMember(@RequestBody MemberCreateRequest request) {
        String memberId = memberService.create(request);
        URI location = URI.create("api/member/" + memberId);
        return ResponseEntity.created(location).build();
    }

    // 멤버 수정
    @PutMapping("{memberId}")
    public ResponseEntity<MemberGetResponse> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequest request) {
        MemberGetResponse memberGetResponse = memberService.update(memberId, request);
        return ResponseEntity.ok().body(memberGetResponse);
    }

    // 멤버 삭제
    @DeleteMapping("{memberId}")
    public ResponseEntity<MemberGetResponse> deleteMember(@PathVariable Long memberId) {
        MemberGetResponse memberGetResponse = memberService.delete(memberId);
        return ResponseEntity.ok().body(memberGetResponse);
    }
}
