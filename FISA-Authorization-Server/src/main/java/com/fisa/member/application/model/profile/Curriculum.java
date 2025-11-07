package com.fisa.member.application.model.profile;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Curriculum {

    CLOUD_SERVICE_DEV("클라우드 서비스 개발반", "Cloud Service Development"),
    CLOUD_ENGINEERING("클라우드 엔지니어링반", "Cloud Engineering"),
    AI_ENGINEERING("AI 엔지니어링", "AI Engineering");

    private final String koName;
    private final String enName;

    public static Curriculum findByEnumName(String enumName){
        return Arrays.stream(Curriculum.values())
                .filter(e -> e.name().equals(enumName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("교육과정을 찾을 수 없습니다."));
    }

}
