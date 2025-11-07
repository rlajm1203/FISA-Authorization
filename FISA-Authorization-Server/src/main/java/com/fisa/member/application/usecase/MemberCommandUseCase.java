package com.fisa.member.application.usecase;

import com.fisa.member.application.dto.MemberCreateCommand;
import com.fisa.member.application.model.Member;

public interface MemberCommandUseCase {

    Member signUp(MemberCreateCommand command);

}
