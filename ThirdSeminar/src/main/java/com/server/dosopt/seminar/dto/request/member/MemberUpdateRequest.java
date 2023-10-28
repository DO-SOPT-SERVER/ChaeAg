package com.server.dosopt.seminar.dto.request.member;

//@Data -> 불변 객체를 생성한다는 record의 목적을 방해!!
public record MemberUpdateRequest (
    String name,
    String nickname,
    int age
){}
