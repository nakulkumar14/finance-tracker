package com.sudodeveloper.financetracker.service;

import com.sudodeveloper.financetracker.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
  @Value("${jwt.secret}")
  private String jwtSecret;

  @Value("${jwt.expiration}")
  private long jwtExpirationSecs;

  public String generateToken(User user) {
    SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    return Jwts.builder()
        .subject(user.getName())
        .issuedAt(new Date())
        .expiration(new Date((new Date()).getTime() + jwtExpirationSecs))
//        .signWith(SignatureAlgorithm.HS256, jwtSecret)
        .signWith(key, (SecureDigestAlgorithm) Jwts.SIG.get().forKey(SignatureAlgorithm.HS256.getValue()))
        .compact();
  }

  public String extractUsername(String token) {
    SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    Claims claims = Jwts.parser()
        .verifyWith(key)
        .build()
        .parseSignedClaims(token)
        .getPayload();
    return claims.getSubject();
  }

  public boolean isTokenValid(String token, User user) {
    final String username = extractUsername(token);
    return (username.equals(user.getName())) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(String token) {
    SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    Claims claims = Jwts.parser()
        .verifyWith(key)
        .build()
        .parseSignedClaims(token)
        .getPayload();
    Date expiration = claims.getExpiration();
    return expiration.before(new Date());
  }

}
