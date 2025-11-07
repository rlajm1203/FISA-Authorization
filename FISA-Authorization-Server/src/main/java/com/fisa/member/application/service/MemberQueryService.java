package com.fisa.member.application.service;

import com.fisa.member.application.model.Member;
import com.fisa.member.application.model.MemberId;
import com.fisa.member.application.model.auth.LoginId;
import com.fisa.member.application.model.profile.MemberName;
import com.fisa.member.application.repository.MemberRepository;
import com.fisa.member.application.usecase.MemberQueryUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberQueryService implements MemberQueryUseCase {

    private final MemberRepository memberRepository;

    @Override
    public List<Member> getByName(MemberName name) {
        return List.of();
    }

    @Override
    public Member getById(MemberId id) {
        return null;
    }

    @Override
    public Member getByLoginId(LoginId loginId) {
        return null;
    }
}
