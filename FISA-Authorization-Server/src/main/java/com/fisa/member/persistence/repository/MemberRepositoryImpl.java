package com.fisa.member.persistence.repository;

import com.fisa.member.application.model.Member;
import com.fisa.member.application.model.MemberId;
import com.fisa.member.application.model.auth.LoginId;
import com.fisa.member.application.model.profile.MemberName;
import com.fisa.member.application.repository.MemberRepository;
import com.fisa.member.persistence.entity.JpaAuthInfo;
import com.fisa.member.persistence.entity.JpaMember;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository jpaRepository;

    @Override
    public List<Member> findByName(MemberName name) {
        return jpaRepository.findByName(name.getValue())
                .stream().map(this::toModel).toList();
    }

    @Override
    public Member findById(MemberId id) {
        return jpaRepository.findById(id.getValue())
                .map(this::toModel)
                .orElseThrow(() -> new IllegalArgumentException("Member Not Found : %s".formatted(id.getValue())));
    }

    @Override
    public Member findByLoginId(LoginId loginId) {
        return jpaRepository.findByLoginId(loginId.getValue())
                .map(this::toModel)
                .orElseThrow(() -> new IllegalArgumentException("Member Not Found (loginId) : %s".formatted(loginId.getValue())));
    }

    @Override
    public void save(Member member) {
        jpaRepository.save(toEntity(member));
    }

    private Member toModel(JpaMember jpaMember){
        JpaAuthInfo authInfo = jpaMember.getAuthInfo();
        return Member.load(jpaMember.getId(), jpaMember.getName(), jpaMember.getPhoneNumber(), jpaMember.getGeneration(),
                jpaMember.getEmail(), jpaMember.getCurriculum(), authInfo.getLoginId(), authInfo.getCredential());
    }

    private JpaMember toEntity(Member member){
        return JpaMember.of(
                member.getId().getValue(),
                member.getName().getValue(),
                member.getPhoneNumber().getValue(),
                member.getEmail().getValue(),
                member.getCurriculum(),
                member.getGeneration(),
                member.getAuthInfo().getLoginId().getValue(),
                member.getAuthInfo().getCredential().getValue()
        );
    }
}
