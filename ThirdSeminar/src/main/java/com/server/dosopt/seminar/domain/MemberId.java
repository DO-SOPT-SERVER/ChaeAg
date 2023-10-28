package com.server.dosopt.seminar.domain;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode
public class MemberId implements Serializable {
    private String memberId;
}