package com.server.dosopt.seminar.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate // 생성 시각, 현재 시각으로 초기화 해줌!
    private LocalDateTime createdAt;
    @LastModifiedDate // 수정 시각
    private LocalDateTime updatedAt;
}
