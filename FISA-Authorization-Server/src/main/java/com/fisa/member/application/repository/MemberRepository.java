package com.fisa.member.application.repository;

import com.fisa.member.application.model.Member;
import com.fisa.member.application.model.MemberId;
import com.fisa.member.application.model.auth.LoginId;
import com.fisa.member.application.model.profile.MemberName;
import java.util.List;

public interface MemberRepository {

    List<Member> findByName(MemberName name);

    Member findById(MemberId id);

    Member findByLoginId(LoginId loginId);

    void save(Member member);

}
