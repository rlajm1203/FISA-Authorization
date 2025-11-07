package com.fisa.member.application.model;

import java.util.UUID;
import lombok.Getter;

@Getter
public class MemberId {

    private final UUID id;

    private MemberId(String uuid){
        this.id = UUID.fromString(uuid);
    }

    private MemberId(){
        this.id = UUID.randomUUID();
    }

    public static MemberId createNew(){
        return new MemberId();
    }

    public static MemberId load(String uuid){
        return new MemberId(uuid);
    }

}
