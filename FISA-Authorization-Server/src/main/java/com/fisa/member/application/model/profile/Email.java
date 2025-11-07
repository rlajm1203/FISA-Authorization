package com.fisa.member.application.model.profile;

import lombok.Getter;

@Getter
public class Email {

    private static final String REGEX = "";

    public final String email;

    private Email(String email){
        validate(email);
        this.email = email;
    }

    private void validate(String email) {
    }

    public static Email of(String email){
        return new Email(email);
    }

}
