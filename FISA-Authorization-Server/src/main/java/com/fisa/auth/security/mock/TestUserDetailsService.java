package com.fisa.auth.security.mock;

import java.util.Collections;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/** 테스트용 UserDetailsService */
@Component
public class TestUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
    return new User(memberId, "{noop}password", Collections.emptyList());
  }
}
