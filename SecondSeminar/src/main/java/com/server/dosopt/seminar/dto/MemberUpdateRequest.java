package com.server.dosopt.seminar.dto;

import lombok.Data;

@Data
public class MemberUpdateRequest {
    String name;
    String nickname;
    int age;
}
