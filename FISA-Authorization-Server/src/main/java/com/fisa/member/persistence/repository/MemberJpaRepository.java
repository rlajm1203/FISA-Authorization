package com.fisa.member.persistence.repository;

import com.fisa.member.persistence.entity.JpaMember;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberJpaRepository extends JpaRepository<JpaMember, UUID> {
    List<JpaMember> findByName(String name);

    @Query("SELECT jm FROM JpaMember jm WHERE jm.authInfo.loginId=:loginId")
    Optional<JpaMember> findByLoginId(String loginId);

}
