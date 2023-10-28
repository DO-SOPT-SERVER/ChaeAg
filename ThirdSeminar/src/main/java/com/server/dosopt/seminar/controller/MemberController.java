package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.domain.Member;
import com.server.dosopt.seminar.domain.Message;
import com.server.dosopt.seminar.domain.MessageEnum;
import com.server.dosopt.seminar.domain.StatusEnum;
import com.server.dosopt.seminar.dto.request.member.MemberCreateRequest;
import com.server.dosopt.seminar.dto.response.member.MemberGetResponse;
import com.server.dosopt.seminar.dto.request.member.MemberUpdateRequest;
import com.server.dosopt.seminar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Message message = new Message();
    private Member member;

    private void setMessage(StatusEnum status, MessageEnum type, Object data) {
        message.setStatus(status);
        message.setMessage(type.message());
        message.setData(data);
    }


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
        member = memberService.create(request);
        URI location = URI.create("api/member/" + member.getId().toString());
        setMessage(StatusEnum.OK, MessageEnum.CRETAE, member);
        return ResponseEntity.created(location).body(message);
    }

    // 멤버 수정
    @PutMapping("{memberId}")
    public ResponseEntity<Message> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequest request) {
        member = memberService.update(memberId, request);
        setMessage(StatusEnum.OK, MessageEnum.UPDATE, member);
        return ResponseEntity.ok().body(message);
    }

    // 멤버 삭제
    @DeleteMapping("{memberId}")
    public ResponseEntity<Message> deleteMember(@PathVariable Long memberId) {
        member = memberService.delete(memberId);
        setMessage(StatusEnum.OK, MessageEnum.DELETE, member);
        return ResponseEntity.ok().body(message);
    }
}
