package com.fisa.member.application.model;

import com.fisa.member.application.model.auth.AuthInfo;
import com.fisa.member.application.model.profile.Curriculum;
import com.fisa.member.application.model.profile.Email;
import com.fisa.member.application.model.profile.MemberName;
import com.fisa.member.application.model.profile.PhoneNumber;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

    private final MemberId id;
    private final MemberName name;
    private final PhoneNumber phoneNumber;
    private final Integer generation;
    private final Email email;
    private final Curriculum curriculum;
    private final AuthInfo authInfo;

    @Builder
    private Member(
                   MemberId id,
                   MemberName name,
                   PhoneNumber phoneNumber,
                   Integer generation,
                   Email email,
                   Curriculum curriculum,
                   AuthInfo authInfo){
        this.id = id;
        this.curriculum = curriculum;
        this.phoneNumber = phoneNumber;
        this.generation = generation;
        this.email = email;
        this.name = name;
        this.authInfo = authInfo;
    }

    public static Member create(String name, String phoneNumber, int generation, String email, String curriculum, String loginId, String credential){
        return Member.builder()
                .id(MemberId.createNew())
                .curriculum(Curriculum.findByEnumName(curriculum))
                .email(Email.of(email))
                .phoneNumber(PhoneNumber.of(phoneNumber))
                .generation(generation)
                .name(MemberName.of(name))
                .authInfo(AuthInfo.create(loginId, credential))
                .build();
    }

}
