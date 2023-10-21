package com.server.dosopt.seminar.service;

import com.server.dosopt.seminar.domain.Member;
import com.server.dosopt.seminar.dto.MemberCreateRequest;
import com.server.dosopt.seminar.dto.MemberGetResponse;
import com.server.dosopt.seminar.dto.MemberUpdateRequest;
import com.server.dosopt.seminar.repository.MemberRepository;
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

    private final MemberRepository memberRepository;

    public MemberGetResponse getByIdV1(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        MemberGetResponse response = MemberGetResponse.of(member);

        return response;
    }

    public MemberGetResponse getByIdV2(Long memberId) {
//        return MemberGetResponse.of(findById(memberId));
        return MemberGetResponse.of(memberRepository.findByIdOrThrow(memberId));
    }

    public List<MemberGetResponse> getMembers() {
        return memberRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public Member create(MemberCreateRequest request) {
        return memberRepository.save(Member.builder()
                        .name(request.name())
                        .nickname(request.nickname())
                        .age(request.age())
                        .sopt(request.sopt())
                        .build());
    }

    @Transactional
    public Member update(Long id, MemberUpdateRequest request) {
        Member member = findById(id);
        member.updateMember(request.name(), request.nickname(), request.age());
        return member;
    }

    @Transactional
    public Member delete(Long id) {
        Member member = findById(id);
        memberRepository.delete(member);
        return member;
    }

    private Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다."));
    }

}
