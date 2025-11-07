package com.fisa.member.application.model.profile;

import lombok.Getter;

@Getter
public class Email {

    private static final String REGEX = "";

    private final String value;

    private Email(String email){
        validate(email);
        this.value = email;
    }

    private void validate(String email) {
    }

    public static Email of(String email){
        return new Email(email);
    }

}
