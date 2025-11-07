package com.fisa.member.persistence.entity;

import com.fisa.member.application.model.profile.Curriculum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class JpaMember {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int generation;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Curriculum curriculum;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "member")
    private JpaAuthInfo authInfo;

    public static JpaMember of(UUID id, String name, String phoneNumber, String email, Curriculum curriculum, int generation, String loginId, String credential){
        return JpaMember.builder()
                .authInfo(JpaAuthInfo.of(loginId, credential))
                .email(email)
                .curriculum(curriculum)
                .generation(generation)
                .phoneNumber(phoneNumber)
                .name(name)
                .id(id)
                .build();
    }


}
