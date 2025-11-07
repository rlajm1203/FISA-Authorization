package com.fisa.auth.security.jwt;

import static com.fisa.auth.security.jwt.JwtConst.CLAIM_ISSUER;
import static com.fisa.auth.security.jwt.JwtConst.CLAIM_ROLE;
import static com.fisa.auth.security.jwt.JwtConst.CLAIM_USER_ID;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

@Component
public class UserJwtGenerator {

  private static final ZoneId KST = ZoneId.of("Asia/Seoul");
  private static final JwsHeader header = JwsHeader.with(SignatureAlgorithm.RS256).build();

  private final JwtProperties jwtProperties;
  private final JwtEncoder jwtEncoder;

  public UserJwtGenerator(JwtProperties jwtProperties, JwtEncoder jwtEncoder) {
    this.jwtEncoder = jwtEncoder;
    this.jwtProperties = jwtProperties;
  }

  public Jwt createAccessToken(UUID memberId, Collection<? extends GrantedAuthority> authorities) {
    ZonedDateTime now = LocalDateTime.now().atZone(KST);
    JwtClaimsSet claimsSet =
        JwtClaimsSet.builder()
            .claim(CLAIM_USER_ID, memberId)
            .claim(CLAIM_ROLE, authorities)
            .issuer(CLAIM_ISSUER)
            .issuedAt(now.toInstant())
            .expiresAt(now.toInstant().plus(jwtProperties.getAccessTokenExpiration()))
            .build();

    return jwtEncoder.encode(JwtEncoderParameters.from(header, claimsSet));
  }

  public Jwt createRefreshToken(UUID memberId) {
    ZonedDateTime now = LocalDateTime.now().atZone(KST);
    JwtClaimsSet claimsSet =
        JwtClaimsSet.builder()
            .claim(CLAIM_USER_ID, memberId)
            .issuer(CLAIM_ISSUER)
            .issuedAt(now.toInstant())
            .expiresAt(now.toInstant().plus(jwtProperties.getRefreshTokenExpiration()))
            .build();

    return jwtEncoder.encode(JwtEncoderParameters.from(header, claimsSet));
  }
}
