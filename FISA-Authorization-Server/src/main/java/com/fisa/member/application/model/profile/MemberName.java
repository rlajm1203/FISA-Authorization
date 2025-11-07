package com.fisa.member.application.model.profile;

import lombok.Getter;

@Getter
public class MemberName {

    private final String value;

    private MemberName(String name){
        this.value = name;
    }

    public static MemberName of(String name){
        return new MemberName(name);
    }

}
