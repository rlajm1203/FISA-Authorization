package com.fisa.member.application.model.auth;

import lombok.Getter;

@Getter
public class LoginId {

    private final String REGEX = "";

    private final String loginId;

    private LoginId(String loginId){
        validate(loginId);
        this.loginId = loginId;
    }

    private void validate(String loginId) {

    }

    public static LoginId of(String loginId){
        return new LoginId(loginId);
    }

}
