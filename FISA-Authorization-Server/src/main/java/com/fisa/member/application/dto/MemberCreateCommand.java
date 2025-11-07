package com.fisa.member.application.dto;

import com.fisa.member.application.model.auth.AuthInfo;
import com.fisa.member.application.model.profile.Curriculum;
import com.fisa.member.application.model.profile.Email;
import com.fisa.member.application.model.profile.MemberName;
import com.fisa.member.application.model.profile.PhoneNumber;

public record MemberCreateCommand(
        String name,
        String phoneNumber,
        String email,
        String curriculum,
        String loginId,
        String credential,
        int generation
) {
}
