package com.server.dosopt.seminar.repository;

import com.server.dosopt.seminar.domain.ServiceMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceMemberJpaRepository extends JpaRepository<ServiceMember, Long> {
    ServiceMember findByNickname(String nickname);
}
