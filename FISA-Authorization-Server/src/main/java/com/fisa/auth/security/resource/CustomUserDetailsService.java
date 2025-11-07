package com.fisa.auth.security.resource;

import com.fisa.member.application.model.Member;
import com.fisa.member.application.model.auth.AuthInfo;
import com.fisa.member.application.model.auth.LoginId;
import com.fisa.member.application.repository.MemberRepository;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Member member = memberRepository.findByLoginId(LoginId.of(username));
    AuthInfo authInfo = member.getAuthInfo();

    return new User(username, authInfo.getCredential().getValue(), Collections.emptyList());
  }
}
