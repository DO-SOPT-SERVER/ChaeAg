package com.server.dosopt.seminar.service;

import com.server.dosopt.seminar.domain.Member;
import com.server.dosopt.seminar.dto.request.member.MemberCreateRequest;
import com.server.dosopt.seminar.dto.response.member.MemberGetResponse;
import com.server.dosopt.seminar.dto.request.member.MemberUpdateRequest;
import com.server.dosopt.seminar.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getByIdV1(Long memberId) {
        Member member = memberJpaRepository.findById(memberId).get();
        MemberGetResponse response = MemberGetResponse.of(member);

        return response;
    }

    public MemberGetResponse getByIdV2(Long memberId) {
//        return MemberGetResponse.of(findById(memberId));
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(memberId));
    }

    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public Member create(MemberCreateRequest request) {
        return memberJpaRepository.save(Member.builder()
                        .name(request.name())
                        .nickname(request.nickname())
                        .age(request.age())
                        .sopt(request.sopt())
                        .build());
    }

    @Transactional
    public Member update(Long memberId, MemberUpdateRequest request) {
        Member member = findById(memberId);
        member.updateMember(request.name(), request.nickname(), request.age());
        return member;
    }

    @Transactional
    public Member delete(Long memberId) {
        Member member = findById(memberId);
        memberJpaRepository.delete(member);
        return member;
    }

    private Member findById(Long memberId) {
        return memberJpaRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다."));
    }

}
