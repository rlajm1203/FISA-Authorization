package com.fisa.member.application.model.auth;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AuthInfo {

    private final LoginId loginId;
    private final Credential credential;

    @Builder(access = AccessLevel.PRIVATE)
    private AuthInfo(LoginId loginId,
                    Credential credential){
        this.credential = credential;
        this.loginId = loginId;
    }

    public static AuthInfo create(String loginId, String credential){
        return AuthInfo.builder()
                .credential(Credential.of(credential))
                .loginId(LoginId.of(loginId))
                .build();
    }


}
