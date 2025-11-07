package com.fisa.member.application.service;

import com.fisa.member.application.dto.MemberCreateCommand;
import com.fisa.member.application.model.Member;
import com.fisa.member.application.repository.MemberRepository;
import com.fisa.member.application.usecase.MemberCommandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberCommandService implements MemberCommandUseCase {

    private final MemberRepository memberRepository;

    @Override
    public Member signUp(MemberCreateCommand command) {
        try{
            Member member = createNewMember(command);
            
            memberRepository.save(member);
            
            return member;
        } catch (DataIntegrityViolationException e){
            throw new IllegalArgumentException("UnAvailable Login Id");
        }
    }

    private Member createNewMember(MemberCreateCommand command){
        return Member.create(
                command.name(),
                command.phoneNumber(),
                command.generation(),
                command.email(),
                command.curriculum(),
                command.loginId(),
                command.credential()
        ) ;
    }
}
