package com.fisa.member.application.model.profile;

import lombok.Getter;

@Getter
public class MemberName {

    private final String name;

    private MemberName(String name){
        this.name = name;
    }

    public static MemberName of(String name){
        return new MemberName(name);
    }

}
