package com.fisa.member.application.model.profile;

import lombok.Getter;

@Getter
public class PhoneNumber {

    private static final String REGEX = "";

    private final String phoneNumber;

    public PhoneNumber(String phoneNumber){
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validate(String phoneNumber) {
    }

    public static PhoneNumber of(String phoneNumber){
        return new PhoneNumber(phoneNumber);
    }

}
