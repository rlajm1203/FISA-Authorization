package com.fisa.member.application.usecase;

import com.fisa.member.application.model.Member;
import com.fisa.member.application.model.MemberId;
import com.fisa.member.application.model.auth.LoginId;
import com.fisa.member.application.model.profile.MemberName;
import java.util.List;

public interface MemberQueryUseCase {

    List<Member> getByName(MemberName name);

    Member getById(MemberId id);

    Member getByLoginId(LoginId loginId);

}
