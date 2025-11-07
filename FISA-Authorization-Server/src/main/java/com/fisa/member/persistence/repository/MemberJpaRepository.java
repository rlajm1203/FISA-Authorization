package com.fisa.member.persistence.repository;

import com.fisa.member.persistence.entity.JpaMember;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<JpaMember, UUID> {
    List<JpaMember> findByName(String name);
}
