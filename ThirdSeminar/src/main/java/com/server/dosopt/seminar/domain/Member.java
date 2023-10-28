package com.server.dosopt.seminar.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private int age; // 적절한 자료구조 선택 -> int

    @Embedded
    private SOPT sopt;

    public void updateMember(String name, String nickname, int age) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }

    @Builder
    public Member(String name, String nickname, int age, SOPT sopt) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.sopt = sopt;
    }
}
