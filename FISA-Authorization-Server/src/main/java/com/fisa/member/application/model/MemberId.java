package com.fisa.member.application.model;

import java.util.UUID;
import lombok.Getter;

@Getter
public class MemberId {

    private final UUID id;

    private MemberId(UUID uuid){
        this.id = uuid;
    }

    private MemberId(){
        this.id = UUID.randomUUID();
    }

    public static MemberId createNew(){
        return new MemberId();
    }

    public static MemberId load(UUID uuid){
        return new MemberId(uuid);
    }

}
