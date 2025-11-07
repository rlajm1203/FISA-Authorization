package com.fisa.member.application.repository;

import com.fisa.member.application.model.Member;
import com.fisa.member.application.model.MemberId;
import com.fisa.member.application.model.auth.LoginId;
import com.fisa.member.application.model.profile.MemberName;

public interface MemberRepository {

    Member findByName(MemberName name);

    Member findById(MemberId id);

    Member findByLoginId(LoginId loginId);



}
