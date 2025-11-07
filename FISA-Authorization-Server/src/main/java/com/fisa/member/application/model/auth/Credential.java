package com.fisa.member.application.model.auth;

import lombok.Getter;

@Getter
public class Credential {

    private static final String REGEX = "";

    private final String value;

    private Credential(String credential){
        validate(credential);
        this.value = credential;
    }

    private void validate(String credential) {

    }

    public static Credential of(String credential){
        return new Credential(credential);
    }

}
