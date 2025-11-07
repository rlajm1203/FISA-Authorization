package com.fisa.member.application.model;

import java.util.UUID;
import lombok.Getter;

@Getter
public class MemberId {

    private final UUID value;

    private MemberId(UUID uuid){
        this.value = uuid;
    }

    private MemberId(){
        this.value = UUID.randomUUID();
    }

    public static MemberId createNew(){
        return new MemberId();
    }

    public static MemberId load(UUID uuid){
        return new MemberId(uuid);
    }

}
